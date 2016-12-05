package net.fexcraft.mod.ftm.entities;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCart extends TrainEntityBase {
	
	private static final DataParameter<Integer> ROLLING_AMPLITUDE = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> ROLLING_DIRECTION = EntityDataManager.<Integer>createKey(EntityMinecart.class, DataSerializers.VARINT);
    private static final DataParameter<Float> DAMAGE = EntityDataManager.<Float>createKey(EntityMinecart.class, DataSerializers.FLOAT);
    private boolean isInReverse;
    /** Minecart rotational logic matrix */
    private static final int[][][] MATRIX = new int[][][] {{{0, 0, -1}, {0, 0, 1}}, {{ -1, 0, 0}, {1, 0, 0}}, {{ -1, -1, 0}, {1, 0, 0}}, {{ -1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, { -1, 0, 0}}, {{0, 0, -1}, { -1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
    /** appears to be the progress of the turn */
    private int turnProgress;
    private double minecartX;
    private double minecartY;
    private double minecartZ;
    private double minecartYaw;
    private double minecartPitch;
    @SideOnly(Side.CLIENT)
    private double velocityX;
    @SideOnly(Side.CLIENT)
    private double velocityY;
    @SideOnly(Side.CLIENT)
    private double velocityZ;

    /* Forge: Minecart Compatibility Layer Integration. */
    public static float defaultMaxSpeedAirLateral = 0.4f;
    public static float defaultMaxSpeedAirVertical = -1f;
    public static double defaultDragAir = 0.94999998807907104D;
    protected boolean canUseRail = true;
    protected boolean canBePushed = true;

    /* Instance versions of the above physics properties */
    private float currentSpeedRail = 1.2f;
    protected float maxSpeedAirLateral = defaultMaxSpeedAirLateral;
    protected float maxSpeedAirVertical = defaultMaxSpeedAirVertical;
    protected double dragAir = defaultDragAir;
    
    private float weight = 10f;
	
	public EntityCart(World worldIn){
		super(worldIn);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.7F);
	}
	
    public EntityCart(World worldIn, double x, double y, double z){
        this(worldIn);
        this.setPosition(x, y, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }
    
    protected boolean canTriggerWalking(){
        return false;
    }
    
	@Override
	protected void entityInit(){
		this.dataManager.register(ROLLING_AMPLITUDE, Integer.valueOf(0));
        this.dataManager.register(ROLLING_DIRECTION, Integer.valueOf(1));
        this.dataManager.register(DAMAGE, Float.valueOf(0.0F));
	}
	
    public static void func_189673_a(DataFixer df){
        EntityMinecart.func_189669_a(df, "CartRideable");
    }
    
    public boolean processInitialInteract(EntityPlayer player, @Nullable ItemStack stack, EnumHand hand){
        if(player.isSneaking()){
            return false;
        }
        else if(this.isBeingRidden()){
            return true;
        }
        else{
            if(!worldObj.isRemote){
                player.startRiding(this);
            }
            return true;
        }
    }
    
    public void onActivatorRailPass(int x, int y, int z, boolean receivingPower){
        if(receivingPower){
            if(this.isBeingRidden()){
                this.removePassengers();
            }
            if(this.getRollingAmplitude() == 0){
                this.setRollingDirection(-this.getRollingDirection());
                this.setRollingAmplitude(10);
                this.setDamage(50.0F);
                this.setBeenAttacked();
            }
        }
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBox(Entity entityIn){
        return entityIn.canBePushed() ? entityIn.getEntityBoundingBox() : null;
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(){
        return null;
    }
    
    public boolean canBePushed(){
        return canBePushed;
    }
    
    @Override
    public double getMountedYOffset(){
        return 0.125D;
    }
    
    public boolean attackEntityFrom(DamageSource source, float amount){
        if (!this.worldObj.isRemote && !this.isDead){
            if (this.isEntityInvulnerable(source)){
                return false;
            }
            else{
                this.setRollingDirection(-this.getRollingDirection());
                this.setRollingAmplitude(10);
                this.setBeenAttacked();
                this.setDamage(this.getDamage() + amount * 10.0F);
                boolean flag = source.getEntity() instanceof EntityPlayer && ((EntityPlayer)source.getEntity()).capabilities.isCreativeMode;
                if (flag || this.getDamage() > 40.0F){
                    this.removePassengers();
                    if (flag && !this.hasCustomName()){
                        this.setDead();
                    }
                    else{
                        this.killMinecart(source);
                    }
                }
                return true;
            }
        }
        else{
            return true;
        }
    }
    
    public void killMinecart(DamageSource source){
        this.setDead();

        if(this.worldObj.getGameRules().getBoolean("doEntityDrops")){
            ItemStack itemstack = new ItemStack(Items.MINECART, 1);
            if(this.getName() != null){
                itemstack.setStackDisplayName(this.getName());
            }
            this.entityDropItem(itemstack, 0.0F);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void performHurtAnimation(){
        this.setRollingDirection(-this.getRollingDirection());
        this.setRollingAmplitude(10);
        this.setDamage(this.getDamage() + this.getDamage() * 10.0F);
    }
    
    public boolean canBeCollidedWith(){
        return !this.isDead;
    }
    
    public void setDead(){
        super.setDead();
    }
    
    public EnumFacing getAdjustedHorizontalFacing(){
        return this.isInReverse ? this.getHorizontalFacing().getOpposite().rotateY() : this.getHorizontalFacing().rotateY();
    }
    
    public void onUpdate(){
    	if(this.isFrontCoupled()){
    		return;
    	}
        if(this.getRollingAmplitude() > 0){
            this.setRollingAmplitude(this.getRollingAmplitude() - 1);
        }
        if(this.getDamage() > 0.0F){
            this.setDamage(this.getDamage() - 1.0F);
        }
        if(this.posY < -64.0D){
            this.kill();
        }
        if(!this.worldObj.isRemote && this.worldObj instanceof WorldServer){
            this.worldObj.theProfiler.startSection("portal");
            MinecraftServer minecraftserver = this.worldObj.getMinecraftServer();
            int i = this.getMaxInPortalTime();
            if(this.inPortal){
                if(minecraftserver.getAllowNether()){
                    if(!this.isRiding() && this.portalCounter++ >= i){
                        this.portalCounter = i;
                        this.timeUntilPortal = this.getPortalCooldown();
                        int j;
                        if(this.worldObj.provider.getDimensionType().getId() == -1){
                            j = 0;
                        }
                        else{
                            j = -1;
                        }
                        this.changeDimension(j);
                    }
                    this.inPortal = false;
                }
            }
            else{
                if(this.portalCounter > 0){
                    this.portalCounter -= 4;
                }
                if(this.portalCounter < 0){
                    this.portalCounter = 0;
                }
            }
            if(this.timeUntilPortal > 0){
                --this.timeUntilPortal;
            }
            this.worldObj.theProfiler.endSection();
        }
        if(this.worldObj.isRemote){
            if(this.turnProgress > 0){
                double d4 = this.posX + (this.minecartX - this.posX) / (double)this.turnProgress;
                double d5 = this.posY + (this.minecartY - this.posY) / (double)this.turnProgress;
                double d6 = this.posZ + (this.minecartZ - this.posZ) / (double)this.turnProgress;
                double d1 = MathHelper.wrapDegrees(this.minecartYaw - (double)this.rotationYaw);
                this.rotationYaw = (float)((double)this.rotationYaw + d1 / (double)this.turnProgress);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.minecartPitch - (double)this.rotationPitch) / (double)this.turnProgress);
                --this.turnProgress;
                this.setPosition(d4, d5, d6);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
            else{
                this.setPosition(this.posX, this.posY, this.posZ);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
        }
        else{
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;

            if(!this.func_189652_ae()){
                this.motionY -= 0.03999999910593033D;
            }
            int k = MathHelper.floor_double(this.posX);
            int l = MathHelper.floor_double(this.posY);
            int i1 = MathHelper.floor_double(this.posZ);
            if(BlockRailBase.isRailBlock(this.worldObj, new BlockPos(k, l - 1, i1))){
                --l;
            }
            BlockPos blockpos = new BlockPos(k, l, i1);
            IBlockState iblockstate = this.worldObj.getBlockState(blockpos);
            if (canUseRail() && BlockRailBase.isRailBlock(iblockstate)){
                this.moveAlongTrack(blockpos, iblockstate);
                if(iblockstate.getBlock() == Blocks.ACTIVATOR_RAIL){
                    this.onActivatorRailPass(k, l, i1, ((Boolean)iblockstate.getValue(BlockRailPowered.POWERED)).booleanValue());
                }
            }
            else{
                this.moveDerailedMinecart();
            }
            this.doBlockCollisions();
            this.rotationPitch = 0.0F;
            double d0 = this.prevPosX - this.posX;
            double d2 = this.prevPosZ - this.posZ;
            if(d0 * d0 + d2 * d2 > 0.001D){
                this.rotationYaw = (float)(MathHelper.atan2(d2, d0) * 180.0D / Math.PI);
                if (this.isInReverse){
                    this.rotationYaw += 180.0F;
                }
            }
            double d3 = (double)MathHelper.wrapDegrees(this.rotationYaw - this.prevRotationYaw);
            if(d3 < -170.0D || d3 >= 170.0D){
                this.rotationYaw += 180.0F;
                this.isInReverse = !this.isInReverse;
            }
            this.setRotation(this.rotationYaw, this.rotationPitch);
            AxisAlignedBB box = this.getEntityBoundingBox().expand(0.20000000298023224D, 0.0D, 0.20000000298023224D);

            if(canBeRidden() && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.01D){
                List<Entity> list = this.worldObj.getEntitiesInAABBexcluding(this, box, EntitySelectors.<Entity>getTeamCollisionPredicate(this));
                if(!list.isEmpty()){
                    for(int j1 = 0; j1 < list.size(); ++j1){
                        Entity entity1 = (Entity)list.get(j1);
                        if(!(entity1 instanceof EntityPlayer) && !(entity1 instanceof EntityIronGolem) && !(entity1 instanceof EntityCart) && !(entity1 instanceof EntityMinecart) && !this.isBeingRidden() && !entity1.isRiding()){
                            entity1.startRiding(this);
                        }
                        else if(entity1 instanceof EntityCart && !this.isRearCoupled() && entity1 != this){
                        	rear_couple = (ITrainEntity)entity1;
                        	((TrainEntityBase)entity1).front_couple = this;
                        }
                        else{
                            entity1.applyEntityCollision(this);
                        }
                    }
                }
            }
            else{
                for(Entity entity : this.worldObj.getEntitiesWithinAABBExcludingEntity(this, box)){
                    if(!this.isPassenger(entity) && entity.canBePushed() && entity instanceof EntityMinecart){
                        entity.applyEntityCollision(this);
                    }
                }
            }
            this.handleWaterMovement();
        }
        if(!isInReverse && isRearCoupled()){
        	getCoupledEntityRear().updatePositionCall(getRearOffsetBasedOnFacing(this.getHorizontalFacing(), this.getRearCouplingOffset()));
        }
        if(isInReverse && isFrontCoupled()){
        	getCoupledEntityRear().updatePositionCall(getFrontOffsetBasedOnFacing(this.getHorizontalFacing(), this.getFrontCouplingOffset()));
        }
    }
    
    protected double getMaximumSpeed(){
        return 0.8D;
    }
    
    protected void moveDerailedMinecart(){
        double d0 = onGround ? this.getMaximumSpeed() : getMaxSpeedAirLateral();
        this.motionX = MathHelper.clamp_double(this.motionX, -d0, d0);
        this.motionZ = MathHelper.clamp_double(this.motionZ, -d0, d0);
        double moveY = motionY;
        if(getMaxSpeedAirVertical() > 0 && motionY > getMaxSpeedAirVertical()){
            moveY = getMaxSpeedAirVertical();
            if(Math.abs(motionX) < 0.3f && Math.abs(motionZ) < 0.3f){
                moveY = 0.15f;
                motionY = moveY;
            }
        }
        if(this.onGround){
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
        }
        this.moveEntity(this.motionX, moveY, this.motionZ);

        if(!this.onGround){
            this.motionX *= getDragAir();
            this.motionY *= getDragAir();
            this.motionZ *= getDragAir();
        }
    }
    
    protected void moveAlongTrack(BlockPos p_180460_1_, IBlockState p_180460_2_){
        this.fallDistance = 0.0F;
        Vec3d vec3d = this.getPos(this.posX, this.posY, this.posZ);
        this.posY = (double)p_180460_1_.getY();
        boolean flag = false;
        boolean flag1 = false;
        BlockRailBase blockrailbase = (BlockRailBase)p_180460_2_.getBlock();
        if(blockrailbase == Blocks.GOLDEN_RAIL){
            flag = ((Boolean)p_180460_2_.getValue(BlockRailPowered.POWERED)).booleanValue();
            flag1 = !flag;
        }
        double slopeAdjustment = getSlopeAdjustment();
        BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = blockrailbase.getRailDirection(worldObj, p_180460_1_, p_180460_2_, null);
        
        switch (blockrailbase$enumraildirection){
            case ASCENDING_EAST:
                this.motionX -= slopeAdjustment;
                ++this.posY;
                break;
            case ASCENDING_WEST:
                this.motionX += slopeAdjustment;
                ++this.posY;
                break;
            case ASCENDING_NORTH:
                this.motionZ += slopeAdjustment;
                ++this.posY;
                break;
            case ASCENDING_SOUTH:
                this.motionZ -= slopeAdjustment;
                ++this.posY;
                break;
			default:
				break;
        }

        int[][] aint = MATRIX[blockrailbase$enumraildirection.getMetadata()];
        double d1 = (double)(aint[1][0] - aint[0][0]);
        double d2 = (double)(aint[1][2] - aint[0][2]);
        double d3 = Math.sqrt(d1 * d1 + d2 * d2);
        double d4 = this.motionX * d1 + this.motionZ * d2;

        if(d4 < 0.0D){
            d1 = -d1;
            d2 = -d2;
        }
        
        double d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

        if(d5 > 2.0D){
            d5 = 2.0D;
        }

        this.motionX = d5 * d1 / d3;
        this.motionZ = d5 * d2 / d3;
        Entity entity = this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);

        if(entity instanceof EntityLivingBase){
            double d6 = (double)((EntityLivingBase)entity).moveForward;
            if(d6 > 0.0D){
                double d7 = -Math.sin((double)(entity.rotationYaw * 0.017453292F));
                double d8 = Math.cos((double)(entity.rotationYaw * 0.017453292F));
                double d9 = this.motionX * this.motionX + this.motionZ * this.motionZ;

                if(d9 < 0.01D){
                    this.motionX += d7 * 0.1D;
                    this.motionZ += d8 * 0.1D;
                    flag1 = false;
                }
            }
        }

        if(flag1 && shouldDoRailFunctions()){
            double d17 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if(d17 < 0.03D){
                this.motionX *= 0.0D;
                this.motionY *= 0.0D;
                this.motionZ *= 0.0D;
            }
            else{
                this.motionX *= 0.5D;
                this.motionY *= 0.0D;
                this.motionZ *= 0.5D;
            }
        }

        double d18 = (double)p_180460_1_.getX() + 0.5D + (double)aint[0][0] * 0.5D;
        double d19 = (double)p_180460_1_.getZ() + 0.5D + (double)aint[0][2] * 0.5D;
        double d20 = (double)p_180460_1_.getX() + 0.5D + (double)aint[1][0] * 0.5D;
        double d21 = (double)p_180460_1_.getZ() + 0.5D + (double)aint[1][2] * 0.5D;
        d1 = d20 - d18;
        d2 = d21 - d19;
        double d10;

        if(d1 == 0.0D){
            this.posX = (double)p_180460_1_.getX() + 0.5D;
            d10 = this.posZ - (double)p_180460_1_.getZ();
        }
        else if(d2 == 0.0D){
            this.posZ = (double)p_180460_1_.getZ() + 0.5D;
            d10 = this.posX - (double)p_180460_1_.getX();
        }
        else{
            double d11 = this.posX - d18;
            double d12 = this.posZ - d19;
            d10 = (d11 * d1 + d12 * d2) * 2.0D;
        }

        this.posX = d18 + d1 * d10;
        this.posZ = d19 + d2 * d10;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.moveMinecartOnRail(p_180460_1_);
        if (aint[0][1] != 0 && MathHelper.floor_double(this.posX) - p_180460_1_.getX() == aint[0][0] && MathHelper.floor_double(this.posZ) - p_180460_1_.getZ() == aint[0][2]){
            this.setPosition(this.posX, this.posY + (double)aint[0][1], this.posZ);
        }
        else if (aint[1][1] != 0 && MathHelper.floor_double(this.posX) - p_180460_1_.getX() == aint[1][0] && MathHelper.floor_double(this.posZ) - p_180460_1_.getZ() == aint[1][2]){
            this.setPosition(this.posX, this.posY + (double)aint[1][1], this.posZ);
        }

        this.applyDrag();
        Vec3d vec3d1 = this.getPos(this.posX, this.posY, this.posZ);

        if (vec3d1 != null && vec3d != null){
            double d14 = (vec3d.yCoord - vec3d1.yCoord) * 0.05D;
            d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            
            if (d5 > 0.0D){
                this.motionX = this.motionX / d5 * (d5 + d14);
                this.motionZ = this.motionZ / d5 * (d5 + d14);
            }
            
            this.setPosition(this.posX, vec3d1.yCoord, this.posZ);
        }

        int j = MathHelper.floor_double(this.posX);
        int i = MathHelper.floor_double(this.posZ);

        if (j != p_180460_1_.getX() || i != p_180460_1_.getZ()){
            d5 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.motionX = d5 * (double)(j - p_180460_1_.getX());
            this.motionZ = d5 * (double)(i - p_180460_1_.getZ());
        }


        /*if(shouldDoRailFunctions()){
            ((BlockRailBase)p_180460_2_.getBlock()).onMinecartPass(worldObj, this, p_180460_1_);
        }*/

        if (flag && shouldDoRailFunctions()){
            double d15 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

            if (d15 > 0.01D){
                //double d16 = 0.06D;
                this.motionX += this.motionX / d15 * 0.06D;
                this.motionZ += this.motionZ / d15 * 0.06D;
            }
            else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.EAST_WEST){
                if (this.worldObj.getBlockState(p_180460_1_.west()).isNormalCube()){
                    this.motionX = 0.02D;
                }
                else if (this.worldObj.getBlockState(p_180460_1_.east()).isNormalCube()){
                    this.motionX = -0.02D;
                }
            }
            else if (blockrailbase$enumraildirection == BlockRailBase.EnumRailDirection.NORTH_SOUTH){
                if (this.worldObj.getBlockState(p_180460_1_.north()).isNormalCube()){
                    this.motionZ = 0.02D;
                }
                else if (this.worldObj.getBlockState(p_180460_1_.south()).isNormalCube()){
                    this.motionZ = -0.02D;
                }
            }
        }
    }

    protected void applyDrag(){
        if (this.isBeingRidden()){
            this.motionX *= 0.996999979019165D;
            this.motionY *= 0.0D;
            this.motionZ *= 0.996999979019165D;
        }
        else{
            this.motionX *= 0.9599999785423279D;
            this.motionY *= 0.0D;
            this.motionZ *= 0.9599999785423279D;
        }
    }
    
    public void setPosition(double x, double y, double z){
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        float f = this.width / 2.0F;
        float f1 = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(x - (double)f, y, z - (double)f, x + (double)f, y + (double)f1, z + (double)f));
    }

    @SideOnly(Side.CLIENT)
    public Vec3d getPosOffset(double p_70495_1_, double p_70495_3_, double p_70495_5_, double p_70495_7_){
        int i = MathHelper.floor_double(p_70495_1_);
        int j = MathHelper.floor_double(p_70495_3_);
        int k = MathHelper.floor_double(p_70495_5_);

        if(BlockRailBase.isRailBlock(this.worldObj, new BlockPos(i, j - 1, k))){
            --j;
        }

        IBlockState iblockstate = this.worldObj.getBlockState(new BlockPos(i, j, k));

        if(BlockRailBase.isRailBlock(iblockstate)){
            BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = (BlockRailBase.EnumRailDirection)iblockstate.getValue(((BlockRailBase)iblockstate.getBlock()).getShapeProperty());
            p_70495_3_ = (double)j;

            if (blockrailbase$enumraildirection.isAscending()){
                p_70495_3_ = (double)(j + 1);
            }

            int[][] aint = MATRIX[blockrailbase$enumraildirection.getMetadata()];
            double d0 = (double)(aint[1][0] - aint[0][0]);
            double d1 = (double)(aint[1][2] - aint[0][2]);
            double d2 = Math.sqrt(d0 * d0 + d1 * d1);
            d0 = d0 / d2;
            d1 = d1 / d2;
            p_70495_1_ = p_70495_1_ + d0 * p_70495_7_;
            p_70495_5_ = p_70495_5_ + d1 * p_70495_7_;

            if (aint[0][1] != 0 && MathHelper.floor_double(p_70495_1_) - i == aint[0][0] && MathHelper.floor_double(p_70495_5_) - k == aint[0][2]){
                p_70495_3_ += (double)aint[0][1];
            }
            else if (aint[1][1] != 0 && MathHelper.floor_double(p_70495_1_) - i == aint[1][0] && MathHelper.floor_double(p_70495_5_) - k == aint[1][2]){
                p_70495_3_ += (double)aint[1][1];
            }

            return this.getPos(p_70495_1_, p_70495_3_, p_70495_5_);
        }
        else{
            return null;
        }
    }

    public Vec3d getPos(double p_70489_1_, double p_70489_3_, double p_70489_5_){
        int i = MathHelper.floor_double(p_70489_1_);
        int j = MathHelper.floor_double(p_70489_3_);
        int k = MathHelper.floor_double(p_70489_5_);

        if(BlockRailBase.isRailBlock(this.worldObj, new BlockPos(i, j - 1, k))){
            --j;
        }

        IBlockState iblockstate = this.worldObj.getBlockState(new BlockPos(i, j, k));

        if(BlockRailBase.isRailBlock(iblockstate)){
            BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = (BlockRailBase.EnumRailDirection)iblockstate.getValue(((BlockRailBase)iblockstate.getBlock()).getShapeProperty());
            int[][] aint = MATRIX[blockrailbase$enumraildirection.getMetadata()];
            double d0 = (double)i + 0.5D + (double)aint[0][0] * 0.5D;
            double d1 = (double)j + 0.0625D + (double)aint[0][1] * 0.5D;
            double d2 = (double)k + 0.5D + (double)aint[0][2] * 0.5D;
            double d3 = (double)i + 0.5D + (double)aint[1][0] * 0.5D;
            double d4 = (double)j + 0.0625D + (double)aint[1][1] * 0.5D;
            double d5 = (double)k + 0.5D + (double)aint[1][2] * 0.5D;
            double d6 = d3 - d0;
            double d7 = (d4 - d1) * 2.0D;
            double d8 = d5 - d2;
            double d9;

            if(d6 == 0.0D){
                d9 = p_70489_5_ - (double)k;
            }
            else if(d8 == 0.0D){
                d9 = p_70489_1_ - (double)i;
            }
            else{
                double d10 = p_70489_1_ - d0;
                double d11 = p_70489_5_ - d2;
                d9 = (d10 * d6 + d11 * d8) * 2.0D;
            }

            p_70489_1_ = d0 + d6 * d9;
            p_70489_3_ = d1 + d7 * d9;
            p_70489_5_ = d2 + d8 * d9;

            if(d7 < 0.0D){
                ++p_70489_3_;
            }

            if(d7 > 0.0D){
                p_70489_3_ += 0.5D;
            }

            return new Vec3d(p_70489_1_, p_70489_3_, p_70489_5_);
        }
        else{
            return null;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox(){
        return this.getEntityBoundingBox();
    }

    public static void func_189669_a(DataFixer p_189669_0_, String p_189669_1_){
    	
    }
    
    public void applyEntityCollision(Entity entityIn){
        if(!this.worldObj.isRemote){
            if(!entityIn.noClip && !this.noClip){
                if(!this.isPassenger(entityIn)){
                    double d0 = entityIn.posX - this.posX;
                    double d1 = entityIn.posZ - this.posZ;
                    double d2 = d0 * d0 + d1 * d1;

                    if(d2 >= 9.999999747378752E-5D){
                        d2 = (double)MathHelper.sqrt_double(d2);
                        d0 = d0 / d2;
                        d1 = d1 / d2;
                        double d3 = 1.0D / d2;

                        if(d3 > 1.0D){
                            d3 = 1.0D;
                        }

                        d0 = d0 * d3;
                        d1 = d1 * d3;
                        d0 = d0 * 0.10000000149011612D;
                        d1 = d1 * 0.10000000149011612D;
                        d0 = d0 * (double)(1.0F - this.entityCollisionReduction);
                        d1 = d1 * (double)(1.0F - this.entityCollisionReduction);
                        d0 = d0 * 0.5D;
                        d1 = d1 * 0.5D;

                        if(entityIn instanceof EntityMinecart){
                            double d4 = entityIn.posX - this.posX;
                            double d5 = entityIn.posZ - this.posZ;
                            Vec3d vec3d = (new Vec3d(d4, 0.0D, d5)).normalize();
                            Vec3d vec3d1 = (new Vec3d((double)MathHelper.cos(this.rotationYaw * 0.017453292F), 0.0D, (double)MathHelper.sin(this.rotationYaw * 0.017453292F))).normalize();
                            double d6 = Math.abs(vec3d.dotProduct(vec3d1));

                            if(d6 < 0.800000011920929D){
                                return;
                            }

                            double d7 = entityIn.motionX + this.motionX;
                            double d8 = entityIn.motionZ + this.motionZ;

                            if(((EntityMinecart)entityIn).isPoweredCart() && !isPoweredCart()){
                                this.motionX *= 0.20000000298023224D;
                                this.motionZ *= 0.20000000298023224D;
                                this.addVelocity(entityIn.motionX - d0, 0.0D, entityIn.motionZ - d1);
                                entityIn.motionX *= 0.949999988079071D;
                                entityIn.motionZ *= 0.949999988079071D;
                            }
                            else if(!((EntityMinecart)entityIn).isPoweredCart() && isPoweredCart()){
                                entityIn.motionX *= 0.20000000298023224D;
                                entityIn.motionZ *= 0.20000000298023224D;
                                entityIn.addVelocity(this.motionX + d0, 0.0D, this.motionZ + d1);
                                this.motionX *= 0.949999988079071D;
                                this.motionZ *= 0.949999988079071D;
                            }
                            else{
                                d7 = d7 / 2.0D;
                                d8 = d8 / 2.0D;
                                this.motionX *= 0.20000000298023224D;
                                this.motionZ *= 0.20000000298023224D;
                                this.addVelocity(d7 - d0, 0.0D, d8 - d1);
                                entityIn.motionX *= 0.20000000298023224D;
                                entityIn.motionZ *= 0.20000000298023224D;
                                entityIn.addVelocity(d7 + d0, 0.0D, d8 + d1);
                            }
                        }
                        else{
                            this.addVelocity(-d0, 0.0D, -d1);
                            entityIn.addVelocity(d0 / 4.0D, 0.0D, d1 / 4.0D);
                        }
                    }
                }
            }
        }
    }

    /**
     * Set the position and rotation values directly without any clamping.
     */
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport){
        this.minecartX = x;
        this.minecartY = y;
        this.minecartZ = z;
        this.minecartYaw = (double)yaw;
        this.minecartPitch = (double)pitch;
        this.turnProgress = posRotationIncrements + 2;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }
    
    public void setDamage(float damage){
        this.dataManager.set(DAMAGE, Float.valueOf(damage));
    }
    
    @SideOnly(Side.CLIENT)
    public void setVelocity(double x, double y, double z){
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        this.velocityX = this.motionX;
        this.velocityY = this.motionY;
        this.velocityZ = this.motionZ;
    }
    
    public float getDamage(){
        return ((Float)this.dataManager.get(DAMAGE)).floatValue();
    }
    
    public void setRollingAmplitude(int rollingAmplitude){
        this.dataManager.set(ROLLING_AMPLITUDE, Integer.valueOf(rollingAmplitude));
    }
    
    public int getRollingAmplitude(){
        return ((Integer)this.dataManager.get(ROLLING_AMPLITUDE)).intValue();
    }
    
    public void setRollingDirection(int rollingDirection){
        this.dataManager.set(ROLLING_DIRECTION, Integer.valueOf(rollingDirection));
    }
    
    public int getRollingDirection(){
        return ((Integer)this.dataManager.get(ROLLING_DIRECTION)).intValue();
    }

    public EntityMinecart.Type getType(){
		return EntityMinecart.Type.RIDEABLE;
    }

    /* =================================== FORGE START ===========================================*/
    private BlockPos getCurrentRailPosition(){
        int x = MathHelper.floor_double(this.posX);
        int y = MathHelper.floor_double(this.posY);
        int z = MathHelper.floor_double(this.posZ);

        if (BlockRailBase.isRailBlock(this.worldObj, new BlockPos(x, y - 1, z))) y--;
        return new BlockPos(x, y, z);
    }

    protected double getMaxSpeed(){
        if (!canUseRail()) return getMaximumSpeed();
        BlockPos pos = this.getCurrentRailPosition();
        IBlockState state = this.worldObj.getBlockState(pos);
        if (!BlockRailBase.isRailBlock(state)) return getMaximumSpeed();

        float railMaxSpeed = 10f;
        return Math.min(railMaxSpeed, getCurrentCartSpeedCapOnRail());
    }
    
    public void moveMinecartOnRail(BlockPos pos){
        double mX = this.motionX;
        double mZ = this.motionZ;

        if(this.isBeingRidden()){
            mX *= 0.75D;
            mZ *= 0.75D;
        }

        double max = this.getMaxSpeed();
        mX = MathHelper.clamp_double(mX, -max, max);
        mZ = MathHelper.clamp_double(mZ, -max, max);
        this.moveEntity(mX, 0.0D, mZ);
    }
    
    public boolean canUseRail(){
        return canUseRail;
    }
    
    public void setCanUseRail(boolean use){
        canUseRail = use;
    }
    
    public boolean shouldDoRailFunctions(){
        return true;
    }
    
    public boolean isPoweredCart(){
        return getType() == EntityMinecart.Type.FURNACE;
    }
    
    public boolean canBeRidden(){
        return this.getType() == EntityMinecart.Type.RIDEABLE;
    }
    
    public float getMaxCartSpeedOnRail(){
        return 0.8f;
    }
    
    public final float getCurrentCartSpeedCapOnRail(){
        return currentSpeedRail;
    }

    public final void setCurrentCartSpeedCapOnRail(float value){
        value = Math.min(value, getMaxCartSpeedOnRail());
        currentSpeedRail = value;
    }

    public float getMaxSpeedAirLateral(){
        return maxSpeedAirLateral;
    }

    public void setMaxSpeedAirLateral(float value){
        maxSpeedAirLateral = value;
    }

    public float getMaxSpeedAirVertical(){
        return maxSpeedAirVertical;
    }

    public void setMaxSpeedAirVertical(float value){
        maxSpeedAirVertical = value;
    }

    public double getDragAir(){
        return dragAir;
    }

    public void setDragAir(double value)
    {
        dragAir = value;
    }

    public double getSlopeAdjustment(){
        return 0.0078125D;
    }
    
    public int getComparatorLevel(){
        return -1;
    }

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		
	}

	@Override
	public boolean hasEngine(){
		return false;
	}

	@Override
	public float getEnginePower(){
		return 0;
	}

	@Override
	public float getFrontCouplingOffset(){
		return 13;
	}

	@Override
	public float getRearCouplingOffset(){
		return 13;
	}

	@Override
	public float getWeight(){
		return weight;
	}

	@Override
	public void setWeight(float w){
		weight = w;
	}

	@Override
	public void updatePositionCall(Vec3d pos){
		pos = (isInReverse ? this.getFrontOffsetBasedOnFacing(this.getHorizontalFacing(), this.getRearCouplingOffset()) : this.getRearOffsetBasedOnFacing(this.getHorizontalFacing(), this.getFrontCouplingOffset()));
		this.prevPosX = posX;
		this.prevPosY = posY;
		this.prevPosZ = posZ;
		posX = pos.xCoord;
		posY = pos.yCoord;
		posZ = pos.zCoord;
	}
	
}