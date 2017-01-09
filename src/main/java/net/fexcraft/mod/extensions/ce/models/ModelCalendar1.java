package net.fexcraft.mod.extensions.ce.models;

import net.fexcraft.mod.extensions.ce.util.CalendarModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelCalendar1 extends CalendarModelBase
{
	int textureX = 64;
	int textureY = 64;

	public ModelCalendar1() //Same as Filename
	{
		base = new ModelRendererTurbo[4];
		base[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Base0
		base[1] = new ModelRendererTurbo(this, 1, 25, textureX, textureY); // Month
		base[2] = new ModelRendererTurbo(this, 33, 25, textureX, textureY); // Base2
		base[3] = new ModelRendererTurbo(this, 17, 57, textureX, textureY); // Label
		d01 = new ModelRendererTurbo[1];
		d01[0] = new ModelRendererTurbo(this, 41, 1, textureX, textureY); // D01
		d02 = new ModelRendererTurbo[1];
		d02[0] = new ModelRendererTurbo(this, 49, 1, textureX, textureY); // D02
		d03 = new ModelRendererTurbo[1];
		d03[0] = new ModelRendererTurbo(this, 57, 1, textureX, textureY); // D03
		d04 = new ModelRendererTurbo[1];
		d04[0] = new ModelRendererTurbo(this, 41, 9, textureX, textureY); // D04
		d05 = new ModelRendererTurbo[1];
		d05[0] = new ModelRendererTurbo(this, 49, 9, textureX, textureY); // D05
		d06 = new ModelRendererTurbo[1];
		d06[0] = new ModelRendererTurbo(this, 57, 9, textureX, textureY); // D06
		d07 = new ModelRendererTurbo[1];
		d07[0] = new ModelRendererTurbo(this, 41, 17, textureX, textureY); // D07
		d08 = new ModelRendererTurbo[1];
		d08[0] = new ModelRendererTurbo(this, 49, 17, textureX, textureY); // D08
		d09 = new ModelRendererTurbo[1];
		d09[0] = new ModelRendererTurbo(this, 57, 17, textureX, textureY); // D09
		d10 = new ModelRendererTurbo[1];
		d10[0] = new ModelRendererTurbo(this, 1, 33, textureX, textureY); // D10
		d11 = new ModelRendererTurbo[1];
		d11[0] = new ModelRendererTurbo(this, 9, 33, textureX, textureY); // D11
		d12 = new ModelRendererTurbo[1];
		d12[0] = new ModelRendererTurbo(this, 17, 33, textureX, textureY); // D12
		d13 = new ModelRendererTurbo[1];
		d13[0] = new ModelRendererTurbo(this, 25, 33, textureX, textureY); // D13
		d14 = new ModelRendererTurbo[1];
		d14[0] = new ModelRendererTurbo(this, 1, 41, textureX, textureY); // D14
		d15 = new ModelRendererTurbo[1];
		d15[0] = new ModelRendererTurbo(this, 9, 41, textureX, textureY); // D15
		d16 = new ModelRendererTurbo[1];
		d16[0] = new ModelRendererTurbo(this, 17, 41, textureX, textureY); // D16
		d17 = new ModelRendererTurbo[1];
		d17[0] = new ModelRendererTurbo(this, 25, 41, textureX, textureY); // D17
		d18 = new ModelRendererTurbo[1];
		d18[0] = new ModelRendererTurbo(this, 33, 41, textureX, textureY); // D18
		d19 = new ModelRendererTurbo[1];
		d19[0] = new ModelRendererTurbo(this, 41, 41, textureX, textureY); // D19
		d20 = new ModelRendererTurbo[1];
		d20[0] = new ModelRendererTurbo(this, 49, 41, textureX, textureY); // D20
		d21 = new ModelRendererTurbo[1];
		d21[0] = new ModelRendererTurbo(this, 57, 41, textureX, textureY); // D21
		d22 = new ModelRendererTurbo[1];
		d22[0] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // D22
		d23 = new ModelRendererTurbo[1];
		d23[0] = new ModelRendererTurbo(this, 9, 49, textureX, textureY); // D23
		d24 = new ModelRendererTurbo[1];
		d24[0] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // D24
		d25 = new ModelRendererTurbo[1];
		d25[0] = new ModelRendererTurbo(this, 25, 49, textureX, textureY); // D25
		d26 = new ModelRendererTurbo[1];
		d26[0] = new ModelRendererTurbo(this, 33, 49, textureX, textureY); // D26
		d27 = new ModelRendererTurbo[1];
		d27[0] = new ModelRendererTurbo(this, 41, 49, textureX, textureY); // D27
		d28 = new ModelRendererTurbo[1];
		d28[0] = new ModelRendererTurbo(this, 49, 49, textureX, textureY); // D28
		d29 = new ModelRendererTurbo[1];
		d29[0] = new ModelRendererTurbo(this, 57, 49, textureX, textureY); // D29
		d30 = new ModelRendererTurbo[1];
		d30[0] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // D30
		d31 = new ModelRendererTurbo[1];
		d31[0] = new ModelRendererTurbo(this, 9, 57, textureX, textureY); // D31

		base[0].addBox(0F, 0F, 0F, 15, 15, 2, 0F); // Base0
		base[0].setRotationPoint(0.5F, -15.5F, 0F);

		base[1].addBox(0F, 0F, 0F, 14, 3, 1, 0F); // Month
		base[1].setRotationPoint(1F, -15F, 1.8F);

		base[2].addShapeBox(0F, 0F, 0F, 14, 10, 1, 0F, 0.4F, 0.4F, 0F, 0.4F, 0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.4F, 0.4F, 0F, 0.4F, 0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Base2
		base[2].setRotationPoint(1F, -11F, 1.75F);

		base[3].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Label
		base[3].setRotationPoint(1.5F, -2.5F, 2F);
		//base[3].addShapeBox(0F, 0F, 0F, 7, 1, 1, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Label
		//base[3].setRotationPoint(1.5F, -2.5F, 1.75F);

		d01[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D01
		d01[0].setRotationPoint(13F, -11F, 2F);

		d02[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D02
		d02[0].setRotationPoint(11F, -11F, 2F);

		d03[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D03
		d03[0].setRotationPoint(9F, -11F, 2F);

		d04[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D04
		d04[0].setRotationPoint(7F, -11F, 2F);

		d05[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D05
		d05[0].setRotationPoint(5F, -11F, 2F);

		d06[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D06
		d06[0].setRotationPoint(3F, -11F, 2F);

		d07[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D07
		d07[0].setRotationPoint(1F, -11F, 2F);

		d08[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D08
		d08[0].setRotationPoint(13F, -9F, 2F);

		d09[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D09
		d09[0].setRotationPoint(11F, -9F, 2F);

		d10[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D10
		d10[0].setRotationPoint(9F, -9F, 2F);

		d11[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D11
		d11[0].setRotationPoint(7F, -9F, 2F);

		d12[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D12
		d12[0].setRotationPoint(5F, -9F, 2F);

		d13[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D13
		d13[0].setRotationPoint(3F, -9F, 2F);

		d14[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D14
		d14[0].setRotationPoint(1F, -9F, 2F);

		d15[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D15
		d15[0].setRotationPoint(13F, -7F, 2F);

		d16[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D16
		d16[0].setRotationPoint(11F, -7F, 2F);

		d17[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D17
		d17[0].setRotationPoint(9F, -7F, 2F);

		d18[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D18
		d18[0].setRotationPoint(7F, -7F, 2F);

		d19[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D19
		d19[0].setRotationPoint(5F, -7F, 2F);

		d20[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D20
		d20[0].setRotationPoint(3F, -7F, 2F);

		d21[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D21
		d21[0].setRotationPoint(1F, -7F, 2F);

		d22[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D22
		d22[0].setRotationPoint(13F, -5F, 2F);

		d23[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D23
		d23[0].setRotationPoint(11F, -5F, 2F);

		d24[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D24
		d24[0].setRotationPoint(9F, -5F, 2F);

		d25[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D25
		d25[0].setRotationPoint(7F, -5F, 2F);

		d26[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D26
		d26[0].setRotationPoint(5F, -5F, 2F);

		d27[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D27
		d27[0].setRotationPoint(3F, -5F, 2F);

		d28[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D28
		d28[0].setRotationPoint(1F, -5F, 2F);

		d29[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D29
		d29[0].setRotationPoint(13F, -3F, 2F);

		d30[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D30
		d30[0].setRotationPoint(11F, -3F, 2F);

		d31[0].addBox(0F, 0F, 0F, 2, 2, 1, 0F); // D31
		d31[0].setRotationPoint(9F, -3F, 2F);
		
	}
}