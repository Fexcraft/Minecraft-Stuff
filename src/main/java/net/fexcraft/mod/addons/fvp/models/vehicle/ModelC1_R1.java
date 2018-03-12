//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Flan's Flying Mod Version 4.0.x+

// Model: C1_R1
// Model Creator: FEX___96
// Created on: 22.08.2016 - 20:40:40
// Last changed on: 22.08.2016 - 20:40:40

package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.mod.fvm.model.VehicleModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelC1_R1 extends VehicleModel {
	
	int textureX = 512;
	int textureY = 512;

	public ModelC1_R1(){
		initbody_1();
		initbodyDoorOpenColoredPrimary_1();
		initbodyDoorCloseColoredPrimary_1();
		initbodyColoredPrimary_1();
		initsteering_1();
		//translateAll(0F, 0F, 0F);
		//flipAll();
	}

	private void initbody_1(){
		this.creators.add("Ferdinand (FEX___96");
		body = new ModelRendererTurbo[147];
		body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 177, 1, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 209, 1, textureX, textureY); // Box 2
		body[3] = new ModelRendererTurbo(this, 257, 1, textureX, textureY); // Box 3
		body[4] = new ModelRendererTurbo(this, 337, 1, textureX, textureY); // Box 4
		body[5] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 9
		body[6] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 10
		body[7] = new ModelRendererTurbo(this, 377, 97, textureX, textureY); // Box 432
		body[8] = new ModelRendererTurbo(this, 1, 105, textureX, textureY); // Box 433
		body[9] = new ModelRendererTurbo(this, 121, 105, textureX, textureY); // Box 434
		body[10] = new ModelRendererTurbo(this, 257, 105, textureX, textureY); // Box 435
		body[11] = new ModelRendererTurbo(this, 353, 105, textureX, textureY); // Box 436
		body[12] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 437
		body[13] = new ModelRendererTurbo(this, 105, 97, textureX, textureY); // Box 438
		body[14] = new ModelRendererTurbo(this, 121, 97, textureX, textureY); // Box 440
		body[15] = new ModelRendererTurbo(this, 153, 97, textureX, textureY); // Box 441
		body[16] = new ModelRendererTurbo(this, 185, 97, textureX, textureY); // Box 442
		body[17] = new ModelRendererTurbo(this, 233, 97, textureX, textureY); // Box 443
		body[18] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 450
		body[19] = new ModelRendererTurbo(this, 265, 97, textureX, textureY); // Box 451
		body[20] = new ModelRendererTurbo(this, 297, 97, textureX, textureY); // Box 452
		body[21] = new ModelRendererTurbo(this, 321, 97, textureX, textureY); // Box 453
		body[22] = new ModelRendererTurbo(this, 329, 25, textureX, textureY); // Box 454
		body[23] = new ModelRendererTurbo(this, 345, 25, textureX, textureY); // Box 455
		body[24] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 456
		body[25] = new ModelRendererTurbo(this, 417, 105, textureX, textureY); // Box 462
		body[26] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 463
		body[27] = new ModelRendererTurbo(this, 281, 113, textureX, textureY); // Box 464
		body[28] = new ModelRendererTurbo(this, 321, 113, textureX, textureY); // Box 465
		body[29] = new ModelRendererTurbo(this, 449, 113, textureX, textureY); // Box 466
		body[30] = new ModelRendererTurbo(this, 345, 121, textureX, textureY); // Box 467
		body[31] = new ModelRendererTurbo(this, 473, 121, textureX, textureY); // Box 468
		body[32] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 469
		body[33] = new ModelRendererTurbo(this, 169, 129, textureX, textureY); // Box 470
		body[34] = new ModelRendererTurbo(this, 289, 137, textureX, textureY); // Box 471
		body[35] = new ModelRendererTurbo(this, 433, 137, textureX, textureY); // Box 472
		body[36] = new ModelRendererTurbo(this, 265, 145, textureX, textureY); // Box 473
		body[37] = new ModelRendererTurbo(this, 313, 145, textureX, textureY); // Box 474
		body[38] = new ModelRendererTurbo(this, 457, 145, textureX, textureY); // Box 475
		body[39] = new ModelRendererTurbo(this, 337, 153, textureX, textureY); // Box 476
		body[40] = new ModelRendererTurbo(this, 377, 153, textureX, textureY); // Box 477
		body[41] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 478
		body[42] = new ModelRendererTurbo(this, 41, 161, textureX, textureY); // Box 479
		body[43] = new ModelRendererTurbo(this, 177, 161, textureX, textureY); // Box 480
		body[44] = new ModelRendererTurbo(this, 41, 177, textureX, textureY); // Box 503
		body[45] = new ModelRendererTurbo(this, 313, 97, textureX, textureY); // Box 504
		body[46] = new ModelRendererTurbo(this, 337, 97, textureX, textureY); // Box 505
		body[47] = new ModelRendererTurbo(this, 193, 177, textureX, textureY); // Box 506
		body[48] = new ModelRendererTurbo(this, 345, 97, textureX, textureY); // Box 507
		body[49] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 508
		body[50] = new ModelRendererTurbo(this, 361, 25, textureX, textureY); // Box 509
		body[51] = new ModelRendererTurbo(this, 249, 49, textureX, textureY); // Box 510
		body[52] = new ModelRendererTurbo(this, 33, 113, textureX, textureY); // Box 511
		body[53] = new ModelRendererTurbo(this, 97, 113, textureX, textureY); // Box 512
		body[54] = new ModelRendererTurbo(this, 153, 113, textureX, textureY); // Box 513
		body[55] = new ModelRendererTurbo(this, 193, 113, textureX, textureY); // Box 514
		body[56] = new ModelRendererTurbo(this, 369, 193, textureX, textureY); // Box 524
		body[57] = new ModelRendererTurbo(this, 425, 201, textureX, textureY); // Box 525
		body[58] = new ModelRendererTurbo(this, 97, 137, textureX, textureY); // Box 554
		body[59] = new ModelRendererTurbo(this, 153, 137, textureX, textureY); // Box 555
		body[60] = new ModelRendererTurbo(this, 193, 209, textureX, textureY); // Box 556
		body[61] = new ModelRendererTurbo(this, 281, 225, textureX, textureY); // Box 557
		body[62] = new ModelRendererTurbo(this, 129, 121, textureX, textureY); // Box 559
		body[63] = new ModelRendererTurbo(this, 497, 121, textureX, textureY); // Box 560
		body[64] = new ModelRendererTurbo(this, 1, 129, textureX, textureY); // Box 561
		body[65] = new ModelRendererTurbo(this, 225, 129, textureX, textureY); // Box 562
		body[66] = new ModelRendererTurbo(this, 385, 129, textureX, textureY); // Box 563
		body[67] = new ModelRendererTurbo(this, 457, 121, textureX, textureY); // Box 564
		body[68] = new ModelRendererTurbo(this, 481, 241, textureX, textureY); // Box 654
		body[69] = new ModelRendererTurbo(this, 129, 257, textureX, textureY); // Box 656
		body[70] = new ModelRendererTurbo(this, 193, 121, textureX, textureY); // Box 657
		body[71] = new ModelRendererTurbo(this, 89, 145, textureX, textureY); // Box 658
		body[72] = new ModelRendererTurbo(this, 281, 169, textureX, textureY); // Box 659
		body[73] = new ModelRendererTurbo(this, 233, 177, textureX, textureY); // Box 660
		body[74] = new ModelRendererTurbo(this, 1, 225, textureX, textureY); // Box 661
		body[75] = new ModelRendererTurbo(this, 473, 25, textureX, textureY); // Box 662
		body[76] = new ModelRendererTurbo(this, 297, 49, textureX, textureY); // Box 663
		body[77] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 666
		body[78] = new ModelRendererTurbo(this, 305, 1, textureX, textureY); // Box 667
		body[79] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 668
		body[80] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 669
		body[81] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 670
		body[82] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 671
		body[83] = new ModelRendererTurbo(this, 1, 9, textureX, textureY); // Box 672
		body[84] = new ModelRendererTurbo(this, 177, 9, textureX, textureY); // Box 674
		body[85] = new ModelRendererTurbo(this, 217, 9, textureX, textureY); // Box 675
		body[86] = new ModelRendererTurbo(this, 265, 9, textureX, textureY); // Box 676
		body[87] = new ModelRendererTurbo(this, 329, 289, textureX, textureY); // Box 677
		body[88] = new ModelRendererTurbo(this, 481, 217, textureX, textureY); // Box 679
		body[89] = new ModelRendererTurbo(this, 481, 225, textureX, textureY); // Box 680
		body[90] = new ModelRendererTurbo(this, 433, 289, textureX, textureY); // Box 681
		body[91] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 682
		body[92] = new ModelRendererTurbo(this, 305, 9, textureX, textureY); // Box 683
		body[93] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 684
		body[94] = new ModelRendererTurbo(this, 369, 209, textureX, textureY); // Box 685
		body[95] = new ModelRendererTurbo(this, 433, 161, textureX, textureY); // Box 689
		body[96] = new ModelRendererTurbo(this, 89, 177, textureX, textureY); // Box 690
		body[97] = new ModelRendererTurbo(this, 457, 289, textureX, textureY); // Box 691
		body[98] = new ModelRendererTurbo(this, 25, 297, textureX, textureY); // Box 692
		body[99] = new ModelRendererTurbo(this, 193, 265, textureX, textureY); // Box 693
		body[100] = new ModelRendererTurbo(this, 473, 169, textureX, textureY); // Box 694
		body[101] = new ModelRendererTurbo(this, 481, 265, textureX, textureY); // Box 695
		body[102] = new ModelRendererTurbo(this, 233, 297, textureX, textureY); // Box 696
		body[103] = new ModelRendererTurbo(this, 369, 297, textureX, textureY); // Box 697
		body[104] = new ModelRendererTurbo(this, 393, 177, textureX, textureY); // Box 698
		body[105] = new ModelRendererTurbo(this, 185, 185, textureX, textureY); // Box 699
		body[106] = new ModelRendererTurbo(this, 73, 297, textureX, textureY); // Box 700
		body[107] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 701
		body[108] = new ModelRendererTurbo(this, 473, 9, textureX, textureY); // Box 702
		body[109] = new ModelRendererTurbo(this, 425, 209, textureX, textureY); // Box 703
		body[110] = new ModelRendererTurbo(this, 1, 305, textureX, textureY); // Box 704
		body[111] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 705
		body[112] = new ModelRendererTurbo(this, 473, 305, textureX, textureY); // Box 706
		body[113] = new ModelRendererTurbo(this, 337, 185, textureX, textureY); // Box 707
		body[114] = new ModelRendererTurbo(this, 113, 313, textureX, textureY); // Box 708
		body[115] = new ModelRendererTurbo(this, 273, 297, textureX, textureY); // Box 709
		body[116] = new ModelRendererTurbo(this, 489, 185, textureX, textureY); // Box 710
		body[117] = new ModelRendererTurbo(this, 57, 129, textureX, textureY); // Box 725
		body[118] = new ModelRendererTurbo(this, 193, 129, textureX, textureY); // Box 726
		body[119] = new ModelRendererTurbo(this, 289, 193, textureX, textureY); // Box 727
		body[120] = new ModelRendererTurbo(this, 337, 193, textureX, textureY); // Box 728
		body[121] = new ModelRendererTurbo(this, 361, 41, textureX, textureY); // Box 729
		body[122] = new ModelRendererTurbo(this, 385, 41, textureX, textureY); // Box 730
		body[123] = new ModelRendererTurbo(this, 409, 41, textureX, textureY); // Box 731
		body[124] = new ModelRendererTurbo(this, 425, 41, textureX, textureY); // Box 732
		body[125] = new ModelRendererTurbo(this, 489, 41, textureX, textureY); // Box 733
		body[126] = new ModelRendererTurbo(this, 1, 49, textureX, textureY); // Box 734
		body[127] = new ModelRendererTurbo(this, 17, 49, textureX, textureY); // Box 735
		body[128] = new ModelRendererTurbo(this, 473, 57, textureX, textureY); // Box 736
		body[129] = new ModelRendererTurbo(this, 1, 65, textureX, textureY); // Box 737
		body[130] = new ModelRendererTurbo(this, 41, 65, textureX, textureY); // Box 738
		body[131] = new ModelRendererTurbo(this, 65, 65, textureX, textureY); // Box 739
		body[132] = new ModelRendererTurbo(this, 89, 65, textureX, textureY); // Box 740
		body[133] = new ModelRendererTurbo(this, 249, 65, textureX, textureY); // Box 741
		body[134] = new ModelRendererTurbo(this, 265, 65, textureX, textureY); // Box 742
		body[135] = new ModelRendererTurbo(this, 281, 65, textureX, textureY); // Box 743
		body[136] = new ModelRendererTurbo(this, 1, 81, textureX, textureY); // Box 744
		body[137] = new ModelRendererTurbo(this, 65, 81, textureX, textureY); // Box 745
		body[138] = new ModelRendererTurbo(this, 81, 81, textureX, textureY); // Box 746
		body[139] = new ModelRendererTurbo(this, 105, 81, textureX, textureY); // Box 747
		body[140] = new ModelRendererTurbo(this, 177, 81, textureX, textureY); // Box 748
		body[141] = new ModelRendererTurbo(this, 313, 81, textureX, textureY); // Box 749
		body[142] = new ModelRendererTurbo(this, 329, 81, textureX, textureY); // Box 750
		body[143] = new ModelRendererTurbo(this, 441, 193, textureX, textureY); // Box 751
		body[144] = new ModelRendererTurbo(this, 497, 193, textureX, textureY); // Box 752
		body[145] = new ModelRendererTurbo(this, 97, 169, textureX, textureY); // Box 753
		body[146] = new ModelRendererTurbo(this, 105, 321, textureX, textureY); // Box 742

		body[0].addBox(-32F, 1F, -21F, 64, 2, 40, 0F); // Box 0
		body[0].setRotationPoint(0F, -1F, 1F);

		body[1].addShapeBox(0F, 0F, 0F, 10, 2, 18, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 1
		body[1].setRotationPoint(32F, 1F, -9F);

		body[2].addShapeBox(0F, 0F, 0F, 10, 2, 28, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 2
		body[2].setRotationPoint(-42F, 1F, -14F);

		body[3].addBox(0F, 0F, 0F, 3, 3, 34, 0F); // Box 3
		body[3].setRotationPoint(42F, -1F, -17F);

		body[4].addBox(0F, 0F, 0F, 3, 3, 34, 0F); // Box 4
		body[4].setRotationPoint(-45F, -1F, -17F);

		body[5].addShapeBox(0F, 0F, 0F, 10, 2, 18, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 9
		body[5].setRotationPoint(45F, 1F, -9F);

		body[6].addShapeBox(0F, 0F, 0F, 10, 2, 28, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 10
		body[6].setRotationPoint(-55F, 1F, -14F);

		body[7].addShapeBox(0F, 0F, 0F, 58, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F); // Box 432
		body[7].setRotationPoint(-29F, 0.5F, 21F);

		body[8].addShapeBox(0F, 0F, 0F, 58, 3, 1, 0F,0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 433
		body[8].setRotationPoint(-29F, 0.5F, -22F);

		body[9].addShapeBox(0F, 0F, 0F, 64, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 434
		body[9].setRotationPoint(-32F, 3F, 18F);

		body[10].addShapeBox(0F, 0F, 0F, 64, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F); // Box 435
		body[10].setRotationPoint(-32F, 3F, -21F);

		body[11].addBox(0F, 0F, -21F, 3, 3, 42, 0F); // Box 436
		body[11].setRotationPoint(55F, 0F, 0F);

		body[12].addBox(0F, 0F, -21F, 3, 3, 42, 0F); // Box 437
		body[12].setRotationPoint(-58F, 0F, 0F);

		body[13].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1F, -0.5F); // Box 438
		body[13].setRotationPoint(55F, 0.5F, 21F);

		body[14].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F,0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 440
		body[14].setRotationPoint(32F, 1F, -12F);

		body[15].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F,0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F); // Box 441
		body[15].setRotationPoint(45F, 1F, -12F);

		body[16].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F); // Box 442
		body[16].setRotationPoint(45F, 1F, 9F);

		body[17].addShapeBox(0F, 0F, 0F, 10, 2, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, -2F, 0F, 0F, 0F); // Box 443
		body[17].setRotationPoint(32F, 1F, 9F);

		body[18].addShapeBox(0F, 0F, -21F, 2, 4, 42, 0F,0F, 0F, 0.5F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0.5F, 0F, -0.5F, 0.5F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -0.5F, 0.5F); // Box 450
		body[18].setRotationPoint(58F, 0F, 0F);

		body[19].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -1F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 451
		body[19].setRotationPoint(55F, 0.5F, -22F);

		body[20].addShapeBox(0F, 0F, 0F, 3, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 452
		body[20].setRotationPoint(55F, 3F, 15F);

		body[21].addShapeBox(0F, 0F, 0F, 3, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F); // Box 453
		body[21].setRotationPoint(55F, 3F, -20F);

		body[22].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 454
		body[22].setRotationPoint(55F, 3F, -21F);

		body[23].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 455
		body[23].setRotationPoint(55F, 3F, 20F);

		body[24].addShapeBox(0F, 0F, 0F, 3, 1, 30, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F); // Box 456
		body[24].setRotationPoint(55F, 3F, -15F);

		body[25].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 462
		body[25].setRotationPoint(57.65F, -2.7F, -9F);

		body[26].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 463
		body[26].setRotationPoint(57.6F, -3F, -9F);

		body[27].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 464
		body[27].setRotationPoint(57.55F, -3.3F, -9F);

		body[28].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 465
		body[28].setRotationPoint(57.5F, -3.6F, -9F);

		body[29].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 466
		body[29].setRotationPoint(57.45F, -3.9F, -9F);

		body[30].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 467
		body[30].setRotationPoint(57.4F, -4.2F, -9F);

		body[31].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 468
		body[31].setRotationPoint(57.35F, -4.5F, -9F);

		body[32].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 469
		body[32].setRotationPoint(57.3F, -4.8F, -9F);

		body[33].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 470
		body[33].setRotationPoint(57.25F, -5.1F, -9F);

		body[34].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 471
		body[34].setRotationPoint(57.2F, -5.4F, -9F);

		body[35].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 472
		body[35].setRotationPoint(57.15F, -5.7F, -9F);

		body[36].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 473
		body[36].setRotationPoint(57.1F, -6F, -9F);

		body[37].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 474
		body[37].setRotationPoint(57.05F, -6.3F, -9F);

		body[38].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 475
		body[38].setRotationPoint(57F, -6.6F, -9F);

		body[39].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 476
		body[39].setRotationPoint(56.95F, -6.9F, -9F);

		body[40].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 477
		body[40].setRotationPoint(56.9F, -7.2F, -9F);

		body[41].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 478
		body[41].setRotationPoint(56.85F, -7.5F, -9F);

		body[42].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 479
		body[42].setRotationPoint(56.8F, -7.8F, -9F);

		body[43].addShapeBox(0F, 0F, 0F, 1, 1, 18, 0F,0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.5F, 0F); // Box 480
		body[43].setRotationPoint(56.75F, -8.1F, -9F);

		body[44].addShapeBox(0F, 0F, -21F, 2, 4, 42, 0F,0F, 0F, -1F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -0.5F, 0.5F, 0F, -0.5F, 0.5F, 0F, -1F, -1F); // Box 503
		body[44].setRotationPoint(-60F, 0F, 0F);

		body[45].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, 0F, -0.5F); // Box 504
		body[45].setRotationPoint(-58F, 0.5F, 21F);

		body[46].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0.5F, -0.5F, 0F, 0.5F, -0.5F, 0F, 0.5F, 0F, 0F, 0.5F, 0F, 0F, 0F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 505
		body[46].setRotationPoint(-58F, 0.5F, -22F);

		body[47].addShapeBox(0F, 0F, 0F, 3, 1, 30, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 506
		body[47].setRotationPoint(-58F, 3F, -15F);

		body[48].addShapeBox(0F, 0F, 0F, 3, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 507
		body[48].setRotationPoint(-58F, 3F, -20F);

		body[49].addShapeBox(0F, 0F, 0F, 3, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -1.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 508
		body[49].setRotationPoint(-58F, 3F, 15F);

		body[50].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 509
		body[50].setRotationPoint(-58F, 3F, 20F);

		body[51].addShapeBox(0F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 510
		body[51].setRotationPoint(-58F, 3F, -21F);

		body[52].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -1F, -0.5F); // Box 511
		body[52].setRotationPoint(-32F, 0.5F, 21F);

		body[53].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -0.5F, -0.5F); // Box 512
		body[53].setRotationPoint(29F, 0.5F, 21F);

		body[54].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 513
		body[54].setRotationPoint(-32F, 0.5F, -22F);

		body[55].addShapeBox(0F, 0F, 0F, 3, 3, 1, 0F,0F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.5F, 0F, -1F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 514
		body[55].setRotationPoint(29F, 0.5F, -22F);

		body[56].addShapeBox(0F, 0F, 0F, 10, 2, 28, 0F,0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 524
		body[56].setRotationPoint(-55F, -1F, -14F);

		body[57].addShapeBox(0F, 0F, 0F, 10, 2, 28, 0F,0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 525
		body[57].setRotationPoint(-42F, -1F, -14F);

		body[58].addShapeBox(0F, 0F, 0F, 13, 2, 1, 0F,0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 554
		body[58].setRotationPoint(-3.5F, -28.5F, -10.5F);

		body[59].addShapeBox(0F, 0F, 0F, 13, 2, 1, 0F,0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 555
		body[59].setRotationPoint(-3.5F, -28.5F, 9.5F);

		body[60].addShapeBox(0F, 0F, 0F, 1, 2, 19, 0F,0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 556
		body[60].setRotationPoint(-3.5F, -28.5F, -9.5F);

		body[61].addShapeBox(0F, 0F, 0F, 1, 2, 19, 0F,0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F); // Box 557
		body[61].setRotationPoint(8.5F, -28.5F, -9.5F);

		body[62].addShapeBox(0F, 0F, 0F, 3, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 559
		body[62].setRotationPoint(-3.5F, -27F, 17F);

		body[63].addShapeBox(0F, 0F, 0F, 3, 10, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 560
		body[63].setRotationPoint(-3.5F, -20F, 18F);

		body[64].addBox(0F, 0F, 0F, 3, 11, 1, 0F); // Box 561
		body[64].setRotationPoint(-3.5F, -10F, 19F);

		body[65].addBox(0F, 0F, 0F, 3, 11, 1, 0F); // Box 562
		body[65].setRotationPoint(-3.5F, -10F, -20F);

		body[66].addShapeBox(0F, 0F, 0F, 3, 10, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 563
		body[66].setRotationPoint(-3.5F, -20F, -19F);

		body[67].addShapeBox(0F, 0F, 0F, 3, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 564
		body[67].setRotationPoint(-3.5F, -27F, -18F);

		body[68].addShapeBox(0F, 0F, 0F, 3, 2, 10, 0F,0F, 0F, 0F, 0.7F, 0F, 0F, -0.1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0.9F, 0F, 0F, 0.1F, 0F, -1F, -0.2F, 0F, 0F); // Box 654
		body[68].setRotationPoint(54.5F, -6F, 11F);

		body[69].addShapeBox(0F, 0F, 0F, 3, 2, 10, 0F,0F, 0F, 0F, -0.1F, 0F, -1F, 0.7F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0.1F, 0F, -1F, 0.9F, 0F, 0F, 0F, 0F, 0F); // Box 656
		body[69].setRotationPoint(54.5F, -6F, -21F);

		body[70].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, 0F, 0F, -0.1F, 0F, 0F, -0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F); // Box 657
		body[70].setRotationPoint(57.4F, -1.5F, 16F);

		body[71].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, 0F, 0F, -0.3F, 0F, 0F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 658
		body[71].setRotationPoint(57.4F, -1.5F, -19F);

		body[72].addShapeBox(0F, 0F, 0F, 3, 5, 4, 0F,-0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.1F, -0.6F, 0F, -0.9F, 0.3F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, -0.8F); // Box 659
		body[72].setRotationPoint(-58F, -8F, 17F);

		body[73].addShapeBox(0F, 0F, 0F, 3, 5, 4, 0F,-0.6F, 0F, -0.9F, 0F, 0F, -0.1F, 0F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0.3F, 0F, 0F); // Box 660
		body[73].setRotationPoint(-58F, -8F, -21F);

		body[74].addShapeBox(0F, 0F, 0F, 1, 3, 10, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 661
		body[74].setRotationPoint(60F, 0.5F, -5F);
		body[74].rotateAngleZ = -0.03490659F;

		body[75].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F,0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F); // Box 662
		body[75].setRotationPoint(29F, -9F, 20.9F);

		body[76].addShapeBox(0F, 0F, 0F, 2, 1, 1, 0F,0F, 0F, -0.7F, 0F, 0F, -0.7F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F, 0F, 0F, -0.7F, 0F, 0F, -0.7F, 0.5F, 0.5F, 0F, 0.5F, 0.5F, 0F); // Box 663
		body[76].setRotationPoint(29F, -9F, -21.9F);

		body[77].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 666
		body[77].setRotationPoint(30.5F, -2F, 20.1F);

		body[78].addShapeBox(0F, 0.8F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 667
		body[78].setRotationPoint(30.5F, -2F, 20.1F);

		body[79].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 668
		body[79].setRotationPoint(31.5F, -2F, 20.1F);

		body[80].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 669
		body[80].setRotationPoint(30.5F, -2F, 20.1F);
		body[80].rotateAngleZ = 0.17453293F;

		body[81].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 670
		body[81].setRotationPoint(30.1F, -2F, 20.1F);

		body[82].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 671
		body[82].setRotationPoint(29.1F, -2F, 20.1F);

		body[83].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 672
		body[83].setRotationPoint(29.1F, -1.6F, 20.1F);

		body[84].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F); // Box 674
		body[84].setRotationPoint(29F, -2F, 20.1F);
		body[84].rotateAngleZ = 0.17453293F;

		body[85].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, -0.8F, 0F, 0.5F, -0.8F, 0F, -0.3F, -0.8F, 0F, -0.5F, -0.8F, 0F); // Box 675
		body[85].setRotationPoint(29.1F, -1.8F, 20.1F);

		body[86].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,-0.5F, -0.4F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.4F, 0F, -0.5F, -0.4F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, -0.5F, -0.4F, 0F); // Box 676
		body[86].setRotationPoint(29.1F, -1.6F, 20.1F);

		body[87].addBox(0F, 0F, 0F, 12, 1, 12, 0F); // Box 677
		body[87].setRotationPoint(0F, -4F, 4F);

		body[88].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F,0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 679
		body[88].setRotationPoint(0F, -4F, 2F);

		body[89].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 680
		body[89].setRotationPoint(0F, -4F, 16F);

		body[90].addShapeBox(-0.5F, -16F, -7F, 2, 16, 14, 0F,-0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 681
		body[90].setRotationPoint(-1F, -4F, 10F);
		body[90].rotateAngleZ = 0.17453293F;

		body[91].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F,0F, 0F, 0F, -0.05F, 0.2F, 0F, -0.05F, 0.2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F); // Box 682
		body[91].setRotationPoint(-1F, -4F, 4F);

		body[92].addShapeBox(0F, -18F, -3F, 1, 2, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 683
		body[92].setRotationPoint(-1F, -4F, 10F);
		body[92].rotateAngleZ = 0.17453293F;

		body[93].addShapeBox(0F, -18F, 2F, 1, 2, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 684
		body[93].setRotationPoint(-1F, -4F, 10F);
		body[93].rotateAngleZ = 0.17453293F;

		body[94].addShapeBox(-0.5F, -20.5F, -3.5F, 2, 3, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 685
		body[94].setRotationPoint(-1F, -4F, 10F);
		body[94].rotateAngleZ = 0.17453293F;

		body[95].addBox(0F, 0F, -4F, 8, 2, 1, 0F); // Box 689
		body[95].setRotationPoint(2F, -2F, 10F);

		body[96].addBox(0F, 0F, 3F, 8, 2, 1, 0F); // Box 690
		body[96].setRotationPoint(2F, -2F, 10F);

		body[97].addShapeBox(0F, 0F, 0F, 11, 1, 11, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 691
		body[97].setRotationPoint(0.5F, -3F, 4.5F);

		body[98].addShapeBox(0F, -2F, -19F, 4, 9, 38, 0F,0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -1F); // Box 692
		body[98].setRotationPoint(21F, -12F, 0F);

		body[99].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F); // Box 693
		body[99].setRotationPoint(0F, -4F, -4F);

		body[100].addShapeBox(0F, 0F, 0F, 1, 1, 12, 0F,0F, 0F, 0F, -0.05F, 0.2F, 0F, -0.05F, 0.2F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F); // Box 694
		body[100].setRotationPoint(-1F, -4F, -16F);

		body[101].addShapeBox(0F, 0F, 0F, 12, 1, 2, 0F,0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 695
		body[101].setRotationPoint(0F, -4F, -18F);

		body[102].addBox(0F, 0F, 0F, 12, 1, 12, 0F); // Box 696
		body[102].setRotationPoint(0F, -4F, -16F);

		body[103].addShapeBox(0F, 0F, 0F, 11, 1, 11, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -1F); // Box 697
		body[103].setRotationPoint(0.5F, -3F, -15.5F);

		body[104].addBox(0F, 0F, -4F, 8, 2, 1, 0F); // Box 698
		body[104].setRotationPoint(2F, -2F, -10F);

		body[105].addBox(0F, 0F, 3F, 8, 2, 1, 0F); // Box 699
		body[105].setRotationPoint(2F, -2F, -10F);

		body[106].addShapeBox(-0.5F, -16F, -7F, 2, 16, 14, 0F,-0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F, -0.4F, 0F, 0F); // Box 700
		body[106].setRotationPoint(-1F, -4F, -10F);
		body[106].rotateAngleZ = 0.17453293F;

		body[107].addShapeBox(0F, -18F, -3F, 1, 2, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 701
		body[107].setRotationPoint(-1F, -4F, -10F);
		body[107].rotateAngleZ = 0.17453293F;

		body[108].addShapeBox(0F, -18F, 2F, 1, 2, 1, 0F,-0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F); // Box 702
		body[108].setRotationPoint(-1F, -4F, -10F);
		body[108].rotateAngleZ = 0.17453293F;

		body[109].addShapeBox(-0.5F, -20.5F, -3.5F, 2, 3, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 703
		body[109].setRotationPoint(-1F, -4F, -10F);
		body[109].rotateAngleZ = 0.17453293F;

		body[110].addShapeBox(-1F, -1F, -16F, 4, 7, 12, 0F,0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -1F); // Box 704
		body[110].setRotationPoint(21F, -12F, 0F);

		body[111].addShapeBox(-1.2F, 0F, -12.5F, 1, 1, 5, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 705
		body[111].setRotationPoint(21F, -12F, 0F);

		body[112].addShapeBox(-3F, -1.5F, 5F, 5, 7, 12, 0F,0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -1F, 0F, -3F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -1F); // Box 706
		body[112].setRotationPoint(21F, -12F, 0F);

		body[113].addShapeBox(-4F, -1F, -1F, 3, 2, 2, 0F,0F, 1.9F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1.9F, -0.1F, 0F, -2.1F, -0.1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.1F, -0.1F); // Box 707
		body[113].setRotationPoint(19F, -12F, 11F);

		body[114].addShapeBox(-1F, 0F, -4F, 5, 14, 8, 0F,0F, 0F, -2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 708
		body[114].setRotationPoint(21F, -14F, 0F);

		body[115].addShapeBox(-1F, 0F, -3F, 13, 3, 6, 0F,0F, -1F, -2F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, -1F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 709
		body[115].setRotationPoint(8F, -3F, 0F);

		body[116].addShapeBox(-1F, 0F, -4F, 6, 2, 4, 0F,0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 710
		body[116].setRotationPoint(15F, -4F, 2F);

		body[117].addBox(0F, 0F, -0.5F, 1, 4, 1, 0F); // Box 725
		body[117].setRotationPoint(16F, -7F, 0F);
		body[117].rotateAngleZ = 0.17453293F;

		body[118].addBox(0F, 0F, 0F, 1, 1, 2, 0F); // Box 726
		body[118].setRotationPoint(19.9F, -13.5F, -1F);

		body[119].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 727
		body[119].setRotationPoint(19.9F, -11.5F, -1.5F);

		body[120].addShapeBox(0F, 0F, 0F, 1, 1, 3, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 728
		body[120].setRotationPoint(19.9F, -12F, -1.5F);

		body[121].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 729
		body[121].setRotationPoint(19.9F, -12.5F, -1.75F);

		body[122].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 730
		body[122].setRotationPoint(19.9F, -12.5F, 0.75F);

		body[123].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 731
		body[123].setRotationPoint(19.9F, -12.5F, -0.5F);

		body[124].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 732
		body[124].setRotationPoint(19.9F, -13F, -1.75F);

		body[125].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 733
		body[125].setRotationPoint(19.9F, -13F, -0.5F);

		body[126].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 734
		body[126].setRotationPoint(19.9F, -13F, 0.75F);

		body[127].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 735
		body[127].setRotationPoint(19.9F, -13.5F, 1F);

		body[128].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 736
		body[128].setRotationPoint(19.9F, -13.5F, -2F);

		body[129].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 737
		body[129].setRotationPoint(17.9F, -14.5F, 6F);

		body[130].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 738
		body[130].setRotationPoint(17.9F, -13.5F, 6F);

		body[131].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 739
		body[131].setRotationPoint(17.9F, -12.5F, 6F);

		body[132].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 740
		body[132].setRotationPoint(17.9F, -11.5F, 6F);

		body[133].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 741
		body[133].setRotationPoint(17.9F, -11.5F, 7F);

		body[134].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 742
		body[134].setRotationPoint(17.9F, -12.5F, 7F);

		body[135].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 743
		body[135].setRotationPoint(17.9F, -13.5F, 7F);

		body[136].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 744
		body[136].setRotationPoint(17.9F, -14.5F, 7F);

		body[137].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 745
		body[137].setRotationPoint(17.9F, -14.5F, 14F);

		body[138].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 746
		body[138].setRotationPoint(17.9F, -14.5F, 15F);

		body[139].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 747
		body[139].setRotationPoint(17.9F, -13.5F, 15F);

		body[140].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 748
		body[140].setRotationPoint(17.9F, -11.5F, 15F);

		body[141].addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 749
		body[141].setRotationPoint(17.9F, -11.5F, 14F);

		body[142].addShapeBox(0F, 0F, 0F, 1, 2, 1, 0F,0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F, 0F, -0.2F, -0.2F); // Box 750
		body[142].setRotationPoint(17.9F, -13.5F, 14F);

		body[143].addShapeBox(0F, 0F, 0F, 4, 2, 2, 0F,0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 751
		body[143].setRotationPoint(21F, -2F, 7F);

		body[144].addShapeBox(0F, 0F, 0F, 4, 2, 2, 0F,0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 752
		body[144].setRotationPoint(21F, -2F, 13F);

		body[145].addShapeBox(0F, 0F, 0F, 3, 2, 1, 0F,0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 753
		body[145].setRotationPoint(22F, -2F, 12F);

		body[146].addBox(-32F, 1F, -21F, 64, 1, 42, 0F); // Box 742
		body[146].setRotationPoint(0F, 1F, 0F);
	}

	private void initbodyDoorOpenColoredPrimary_1(){
		bodyDoorOpenColoredPrimary = new ModelRendererTurbo[41];
		bodyDoorOpenColoredPrimary[0] = new ModelRendererTurbo(this, 129, 281, textureX, textureY); // Box 610
		bodyDoorOpenColoredPrimary[1] = new ModelRendererTurbo(this, 193, 281, textureX, textureY); // Box 611
		bodyDoorOpenColoredPrimary[2] = new ModelRendererTurbo(this, 217, 145, textureX, textureY); // Box 612
		bodyDoorOpenColoredPrimary[3] = new ModelRendererTurbo(this, 225, 145, textureX, textureY); // Box 613
		bodyDoorOpenColoredPrimary[4] = new ModelRendererTurbo(this, 81, 225, textureX, textureY); // Box 614
		bodyDoorOpenColoredPrimary[5] = new ModelRendererTurbo(this, 345, 145, textureX, textureY); // Box 615
		bodyDoorOpenColoredPrimary[6] = new ModelRendererTurbo(this, 505, 145, textureX, textureY); // Box 616
		bodyDoorOpenColoredPrimary[7] = new ModelRendererTurbo(this, 145, 97, textureX, textureY); // Box 617
		bodyDoorOpenColoredPrimary[8] = new ModelRendererTurbo(this, 177, 97, textureX, textureY); // Box 618
		bodyDoorOpenColoredPrimary[9] = new ModelRendererTurbo(this, 257, 281, textureX, textureY); // Box 619
		bodyDoorOpenColoredPrimary[10] = new ModelRendererTurbo(this, 321, 281, textureX, textureY); // Box 620
		bodyDoorOpenColoredPrimary[11] = new ModelRendererTurbo(this, 337, 153, textureX, textureY); // Box 621
		bodyDoorOpenColoredPrimary[12] = new ModelRendererTurbo(this, 401, 153, textureX, textureY); // Box 622
		bodyDoorOpenColoredPrimary[13] = new ModelRendererTurbo(this, 409, 225, textureX, textureY); // Box 623
		bodyDoorOpenColoredPrimary[14] = new ModelRendererTurbo(this, 1, 161, textureX, textureY); // Box 624
		bodyDoorOpenColoredPrimary[15] = new ModelRendererTurbo(this, 9, 161, textureX, textureY); // Box 625
		bodyDoorOpenColoredPrimary[16] = new ModelRendererTurbo(this, 209, 97, textureX, textureY); // Box 626
		bodyDoorOpenColoredPrimary[17] = new ModelRendererTurbo(this, 361, 113, textureX, textureY); // Box 627
		bodyDoorOpenColoredPrimary[18] = new ModelRendererTurbo(this, 385, 281, textureX, textureY); // Box 628
		bodyDoorOpenColoredPrimary[19] = new ModelRendererTurbo(this, 449, 281, textureX, textureY); // Box 629
		bodyDoorOpenColoredPrimary[20] = new ModelRendererTurbo(this, 49, 161, textureX, textureY); // Box 630
		bodyDoorOpenColoredPrimary[21] = new ModelRendererTurbo(this, 65, 161, textureX, textureY); // Box 631
		bodyDoorOpenColoredPrimary[22] = new ModelRendererTurbo(this, 281, 249, textureX, textureY); // Box 632
		bodyDoorOpenColoredPrimary[23] = new ModelRendererTurbo(this, 201, 161, textureX, textureY); // Box 633
		bodyDoorOpenColoredPrimary[24] = new ModelRendererTurbo(this, 249, 161, textureX, textureY); // Box 634
		bodyDoorOpenColoredPrimary[25] = new ModelRendererTurbo(this, 385, 113, textureX, textureY); // Box 635
		bodyDoorOpenColoredPrimary[26] = new ModelRendererTurbo(this, 97, 121, textureX, textureY); // Box 636
		bodyDoorOpenColoredPrimary[27] = new ModelRendererTurbo(this, 1, 289, textureX, textureY); // Box 637
		bodyDoorOpenColoredPrimary[28] = new ModelRendererTurbo(this, 65, 289, textureX, textureY); // Box 638
		bodyDoorOpenColoredPrimary[29] = new ModelRendererTurbo(this, 145, 169, textureX, textureY); // Box 639
		bodyDoorOpenColoredPrimary[30] = new ModelRendererTurbo(this, 169, 169, textureX, textureY); // Box 640
		bodyDoorOpenColoredPrimary[31] = new ModelRendererTurbo(this, 281, 257, textureX, textureY); // Box 641
		bodyDoorOpenColoredPrimary[32] = new ModelRendererTurbo(this, 177, 169, textureX, textureY); // Box 642
		bodyDoorOpenColoredPrimary[33] = new ModelRendererTurbo(this, 185, 169, textureX, textureY); // Box 643
		bodyDoorOpenColoredPrimary[34] = new ModelRendererTurbo(this, 153, 121, textureX, textureY); // Box 644
		bodyDoorOpenColoredPrimary[35] = new ModelRendererTurbo(this, 273, 137, textureX, textureY); // Box 645
		bodyDoorOpenColoredPrimary[36] = new ModelRendererTurbo(this, 161, 289, textureX, textureY); // Box 646
		bodyDoorOpenColoredPrimary[37] = new ModelRendererTurbo(this, 289, 289, textureX, textureY); // Box 647
		bodyDoorOpenColoredPrimary[38] = new ModelRendererTurbo(this, 97, 273, textureX, textureY); // Box 648
		bodyDoorOpenColoredPrimary[39] = new ModelRendererTurbo(this, 201, 49, textureX, textureY); // Box 652
		bodyDoorOpenColoredPrimary[40] = new ModelRendererTurbo(this, 241, 217, textureX, textureY); // Box 653

		bodyDoorOpenColoredPrimary[0].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 610
		bodyDoorOpenColoredPrimary[0].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[0].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[1].addShapeBox(-27F, -2F, -0.5F, 27, 2, 1, 0F,-0.5F, 0.5F, 0.25F, -1F, 0.5F, 0.25F, -1F, 0.5F, -0.25F, -0.5F, 0.5F, -0.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 611
		bodyDoorOpenColoredPrimary[1].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[1].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[2].addShapeBox(-5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -0.5F, -0.75F, 3F, -0.5F, -0.75F, 3F, -0.5F, 0.75F, -3F, -0.5F, 0.75F); // Box 612
		bodyDoorOpenColoredPrimary[2].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[2].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[3].addShapeBox(-9F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, -1F, 4F, 0F, -1F, 4F, 0F, 1F, -4F, 0F, 1F); // Box 613
		bodyDoorOpenColoredPrimary[3].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[3].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[4].addShapeBox(-25.5F, -17F, -2.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F); // Box 614
		bodyDoorOpenColoredPrimary[4].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[4].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[5].addShapeBox(-26.5F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 615
		bodyDoorOpenColoredPrimary[5].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[5].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[6].addShapeBox(-26.5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F); // Box 616
		bodyDoorOpenColoredPrimary[6].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[6].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[7].addShapeBox(-24F, 0F, -0.1F, 3, 1, 1, 0F,0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0.4F, 0F, 0F, 0.4F, 0F, 0F); // Box 617
		bodyDoorOpenColoredPrimary[7].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[7].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[8].addShapeBox(-12.5F, 0F, -1F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 618
		bodyDoorOpenColoredPrimary[8].setRotationPoint(25F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[8].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[9].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 619
		bodyDoorOpenColoredPrimary[9].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[9].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[10].addShapeBox(-27F, -2F, -0.5F, 27, 2, 1, 0F,-0.5F, 0.5F, -0.25F, -1F, 0.5F, -0.25F, -1F, 0.5F, 0.25F, -0.5F, 0.5F, 0.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 620
		bodyDoorOpenColoredPrimary[10].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[10].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[11].addShapeBox(-5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -0.5F, 0.75F, 3F, -0.5F, 0.75F, 3F, -0.5F, -0.75F, -3F, -0.5F, -0.75F); // Box 621
		bodyDoorOpenColoredPrimary[11].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[11].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[12].addShapeBox(-9F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 1F, 4F, 0F, 1F, 4F, 0F, -1F, -4F, 0F, -1F); // Box 622
		bodyDoorOpenColoredPrimary[12].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[12].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[13].addShapeBox(-25.5F, -17F, 1.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F); // Box 623
		bodyDoorOpenColoredPrimary[13].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[13].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[14].addShapeBox(-26.5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F); // Box 624
		bodyDoorOpenColoredPrimary[14].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[14].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[15].addShapeBox(-26.5F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 625
		bodyDoorOpenColoredPrimary[15].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[15].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[16].addShapeBox(-24F, 0F, -0.9F, 3, 1, 1, 0F,0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F); // Box 626
		bodyDoorOpenColoredPrimary[16].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[16].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[17].addShapeBox(-12.5F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 627
		bodyDoorOpenColoredPrimary[17].setRotationPoint(25F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[17].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[18].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 628
		bodyDoorOpenColoredPrimary[18].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[18].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[19].addShapeBox(-26.5F, -2F, -0.5F, 27, 2, 1, 0F,-1F, 0.5F, 0.25F, -0.5F, 0.5F, 0.25F, -0.5F, 0.5F, -0.25F, -1F, 0.5F, -0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 629
		bodyDoorOpenColoredPrimary[19].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[19].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[20].addShapeBox(-1F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F); // Box 630
		bodyDoorOpenColoredPrimary[20].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[20].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[21].addShapeBox(-1F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 631
		bodyDoorOpenColoredPrimary[21].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[21].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[22].addShapeBox(-18F, -17F, -2.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F); // Box 632
		bodyDoorOpenColoredPrimary[22].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[22].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[23].addShapeBox(-18.5F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, -1F, -4F, 0F, -1F, -4F, 0F, 1F, 4F, 0F, 1F); // Box 633
		bodyDoorOpenColoredPrimary[23].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[23].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[24].addShapeBox(-22.5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, -0.75F, -3F, -0.5F, -0.75F, -3F, -0.5F, 0.75F, 3F, -0.5F, 0.75F); // Box 634
		bodyDoorOpenColoredPrimary[24].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[24].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[25].addShapeBox(-21F, 0F, -0.1F, 3, 1, 1, 0F,0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0.4F, 0F, 0F, 0.4F, 0F, 0F); // Box 635
		bodyDoorOpenColoredPrimary[25].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[25].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[26].addShapeBox(-7.5F, 0F, -1F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 636
		bodyDoorOpenColoredPrimary[26].setRotationPoint(-2.5F, -10F, 20.5F);
		bodyDoorOpenColoredPrimary[26].rotateAngleY = -1.04719755F;

		bodyDoorOpenColoredPrimary[27].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 637
		bodyDoorOpenColoredPrimary[27].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[27].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[28].addShapeBox(-26.5F, -2F, -0.5F, 27, 2, 1, 0F,-1F, 0.5F, -0.25F, -0.5F, 0.5F, -0.25F, -0.5F, 0.5F, 0.25F, -1F, 0.5F, 0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 638
		bodyDoorOpenColoredPrimary[28].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[28].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[29].addShapeBox(-1F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F); // Box 639
		bodyDoorOpenColoredPrimary[29].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[29].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[30].addShapeBox(-1F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 640
		bodyDoorOpenColoredPrimary[30].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[30].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[31].addShapeBox(-18F, -17F, 1.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F); // Box 641
		bodyDoorOpenColoredPrimary[31].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[31].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[32].addShapeBox(-18.5F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 1F, -4F, 0F, 1F, -4F, 0F, -1F, 4F, 0F, -1F); // Box 642
		bodyDoorOpenColoredPrimary[32].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[32].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[33].addShapeBox(-22.5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, 0.75F, -3F, -0.5F, 0.75F, -3F, -0.5F, -0.75F, 3F, -0.5F, -0.75F); // Box 643
		bodyDoorOpenColoredPrimary[33].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[33].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[34].addShapeBox(-21F, 0F, -0.9F, 3, 1, 1, 0F,0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F); // Box 644
		bodyDoorOpenColoredPrimary[34].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[34].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[35].addShapeBox(-7.5F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 645
		bodyDoorOpenColoredPrimary[35].setRotationPoint(-2.5F, -10F, -20.5F);
		bodyDoorOpenColoredPrimary[35].rotateAngleY = 1.04719755F;

		bodyDoorOpenColoredPrimary[36].addShapeBox(-22F, 0F, -13F, 22, 2, 26, 0F,0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 646
		bodyDoorOpenColoredPrimary[36].setRotationPoint(-32F, -12F, 0F);
		bodyDoorOpenColoredPrimary[36].rotateAngleZ = -1.04719755F;

		bodyDoorOpenColoredPrimary[37].addShapeBox(-26F, 0F, -13F, 4, 2, 26, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 647
		bodyDoorOpenColoredPrimary[37].setRotationPoint(-32F, -12F, 0F);
		bodyDoorOpenColoredPrimary[37].rotateAngleZ = -1.04719755F;

		bodyDoorOpenColoredPrimary[38].addShapeBox(-26F, 2F, -13F, 2, 8, 26, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0.8F, 0F, 0F); // Box 648
		bodyDoorOpenColoredPrimary[38].setRotationPoint(-32F, -12F, 0F);
		bodyDoorOpenColoredPrimary[38].rotateAngleZ = -1.04719755F;

		bodyDoorOpenColoredPrimary[39].addShapeBox(-26.5F, 4F, -7F, 1, 1, 12, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 652
		bodyDoorOpenColoredPrimary[39].setRotationPoint(-32F, -12F, 0F);
		bodyDoorOpenColoredPrimary[39].rotateAngleZ = -1.04719755F;

		bodyDoorOpenColoredPrimary[40].addShapeBox(-26.5F, 5F, -6F, 1, 3, 10, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 653
		bodyDoorOpenColoredPrimary[40].setRotationPoint(-32F, -12F, 0F);
		bodyDoorOpenColoredPrimary[40].rotateAngleZ = -1.04719755F;
	}

	private void initbodyDoorCloseColoredPrimary_1(){
		bodyDoorCloseColoredPrimary = new ModelRendererTurbo[41];
		bodyDoorCloseColoredPrimary[0] = new ModelRendererTurbo(this, 105, 209, textureX, textureY); // Box 526
		bodyDoorCloseColoredPrimary[1] = new ModelRendererTurbo(this, 209, 209, textureX, textureY); // Box 528
		bodyDoorCloseColoredPrimary[2] = new ModelRendererTurbo(this, 1, 217, textureX, textureY); // Box 529
		bodyDoorCloseColoredPrimary[3] = new ModelRendererTurbo(this, 417, 241, textureX, textureY); // Box 569
		bodyDoorCloseColoredPrimary[4] = new ModelRendererTurbo(this, 1, 249, textureX, textureY); // Box 570
		bodyDoorCloseColoredPrimary[5] = new ModelRendererTurbo(this, 81, 249, textureX, textureY); // Box 571
		bodyDoorCloseColoredPrimary[6] = new ModelRendererTurbo(this, 193, 249, textureX, textureY); // Box 572
		bodyDoorCloseColoredPrimary[7] = new ModelRendererTurbo(this, 433, 257, textureX, textureY); // Box 573
		bodyDoorCloseColoredPrimary[8] = new ModelRendererTurbo(this, 401, 273, textureX, textureY); // Box 577
		bodyDoorCloseColoredPrimary[9] = new ModelRendererTurbo(this, 1, 281, textureX, textureY); // Box 578
		bodyDoorCloseColoredPrimary[10] = new ModelRendererTurbo(this, 65, 281, textureX, textureY); // Box 579
		bodyDoorCloseColoredPrimary[11] = new ModelRendererTurbo(this, 473, 121, textureX, textureY); // Box 580
		bodyDoorCloseColoredPrimary[12] = new ModelRendererTurbo(this, 481, 121, textureX, textureY); // Box 581
		bodyDoorCloseColoredPrimary[13] = new ModelRendererTurbo(this, 369, 129, textureX, textureY); // Box 583
		bodyDoorCloseColoredPrimary[14] = new ModelRendererTurbo(this, 377, 129, textureX, textureY); // Box 584
		bodyDoorCloseColoredPrimary[15] = new ModelRendererTurbo(this, 33, 137, textureX, textureY); // Box 585
		bodyDoorCloseColoredPrimary[16] = new ModelRendererTurbo(this, 129, 137, textureX, textureY); // Box 586
		bodyDoorCloseColoredPrimary[17] = new ModelRendererTurbo(this, 289, 137, textureX, textureY); // Box 587
		bodyDoorCloseColoredPrimary[18] = new ModelRendererTurbo(this, 297, 137, textureX, textureY); // Box 588
		bodyDoorCloseColoredPrimary[19] = new ModelRendererTurbo(this, 313, 137, textureX, textureY); // Box 589
		bodyDoorCloseColoredPrimary[20] = new ModelRendererTurbo(this, 321, 137, textureX, textureY); // Box 590
		bodyDoorCloseColoredPrimary[21] = new ModelRendererTurbo(this, 337, 137, textureX, textureY); // Box 591
		bodyDoorCloseColoredPrimary[22] = new ModelRendererTurbo(this, 457, 137, textureX, textureY); // Box 592
		bodyDoorCloseColoredPrimary[23] = new ModelRendererTurbo(this, 465, 137, textureX, textureY); // Box 593
		bodyDoorCloseColoredPrimary[24] = new ModelRendererTurbo(this, 153, 145, textureX, textureY); // Box 594
		bodyDoorCloseColoredPrimary[25] = new ModelRendererTurbo(this, 161, 145, textureX, textureY); // Box 595
		bodyDoorCloseColoredPrimary[26] = new ModelRendererTurbo(this, 209, 145, textureX, textureY); // Box 596
		bodyDoorCloseColoredPrimary[27] = new ModelRendererTurbo(this, 337, 177, textureX, textureY); // Box 597
		bodyDoorCloseColoredPrimary[28] = new ModelRendererTurbo(this, 89, 185, textureX, textureY); // Box 599
		bodyDoorCloseColoredPrimary[29] = new ModelRendererTurbo(this, 1, 201, textureX, textureY); // Box 600
		bodyDoorCloseColoredPrimary[30] = new ModelRendererTurbo(this, 89, 209, textureX, textureY); // Box 601
		bodyDoorCloseColoredPrimary[31] = new ModelRendererTurbo(this, 265, 49, textureX, textureY); // Box 602
		bodyDoorCloseColoredPrimary[32] = new ModelRendererTurbo(this, 281, 49, textureX, textureY); // Box 603
		bodyDoorCloseColoredPrimary[33] = new ModelRendererTurbo(this, 425, 57, textureX, textureY); // Box 604
		bodyDoorCloseColoredPrimary[34] = new ModelRendererTurbo(this, 441, 57, textureX, textureY); // Box 605
		bodyDoorCloseColoredPrimary[35] = new ModelRendererTurbo(this, 457, 57, textureX, textureY); // Box 606
		bodyDoorCloseColoredPrimary[36] = new ModelRendererTurbo(this, 161, 89, textureX, textureY); // Box 607
		bodyDoorCloseColoredPrimary[37] = new ModelRendererTurbo(this, 177, 89, textureX, textureY); // Box 608
		bodyDoorCloseColoredPrimary[38] = new ModelRendererTurbo(this, 193, 89, textureX, textureY); // Box 609
		bodyDoorCloseColoredPrimary[39] = new ModelRendererTurbo(this, 1, 17, textureX, textureY); // Box 649
		bodyDoorCloseColoredPrimary[40] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 650

		bodyDoorCloseColoredPrimary[0].addShapeBox(-22F, 0F, -13F, 22, 2, 26, 0F,0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F); // Box 526
		bodyDoorCloseColoredPrimary[0].setRotationPoint(-32F, -12F, 0F);

		bodyDoorCloseColoredPrimary[1].addShapeBox(-26F, 2F, -13F, 2, 8, 26, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.8F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0.8F, 0F, 0F); // Box 528
		bodyDoorCloseColoredPrimary[1].setRotationPoint(-32F, -12F, 0F);

		bodyDoorCloseColoredPrimary[2].addShapeBox(-26F, 0F, -13F, 4, 2, 26, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 529
		bodyDoorCloseColoredPrimary[2].setRotationPoint(-32F, -12F, 0F);

		bodyDoorCloseColoredPrimary[3].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 569
		bodyDoorCloseColoredPrimary[3].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[4].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 570
		bodyDoorCloseColoredPrimary[4].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[5].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 571
		bodyDoorCloseColoredPrimary[5].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[6].addShapeBox(-27F, 0F, -0.5F, 27, 10, 1, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 572
		bodyDoorCloseColoredPrimary[6].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[7].addShapeBox(-27F, -2F, -0.5F, 27, 2, 1, 0F,-0.5F, 0.5F, 0.25F, -1F, 0.5F, 0.25F, -1F, 0.5F, -0.25F, -0.5F, 0.5F, -0.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 573
		bodyDoorCloseColoredPrimary[7].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[8].addShapeBox(-26.5F, -2F, -0.5F, 27, 2, 1, 0F,-1F, 0.5F, 0.25F, -0.5F, 0.5F, 0.25F, -0.5F, 0.5F, -0.25F, -1F, 0.5F, -0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 577
		bodyDoorCloseColoredPrimary[8].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[9].addShapeBox(-26.5F, -2F, -0.5F, 27, 2, 1, 0F,-1F, 0.5F, -0.25F, -0.5F, 0.5F, -0.25F, -0.5F, 0.5F, 0.25F, -1F, 0.5F, 0.25F, 0F, 0F, 0F, -0.5F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F); // Box 578
		bodyDoorCloseColoredPrimary[9].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[10].addShapeBox(-27F, -2F, -0.5F, 27, 2, 1, 0F,-0.5F, 0.5F, -0.25F, -1F, 0.5F, -0.25F, -1F, 0.5F, 0.25F, -0.5F, 0.5F, 0.25F, -0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F); // Box 579
		bodyDoorCloseColoredPrimary[10].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[11].addShapeBox(-5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -0.5F, -0.75F, 3F, -0.5F, -0.75F, 3F, -0.5F, 0.75F, -3F, -0.5F, 0.75F); // Box 580
		bodyDoorCloseColoredPrimary[11].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[12].addShapeBox(-5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -3F, -0.5F, 0.75F, 3F, -0.5F, 0.75F, 3F, -0.5F, -0.75F, -3F, -0.5F, -0.75F); // Box 581
		bodyDoorCloseColoredPrimary[12].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[13].addShapeBox(-22.5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, 0.75F, -3F, -0.5F, 0.75F, -3F, -0.5F, -0.75F, 3F, -0.5F, -0.75F); // Box 583
		bodyDoorCloseColoredPrimary[13].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[14].addShapeBox(-22.5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 3F, -0.5F, -0.75F, -3F, -0.5F, -0.75F, -3F, -0.5F, 0.75F, 3F, -0.5F, 0.75F); // Box 584
		bodyDoorCloseColoredPrimary[14].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[15].addShapeBox(-26.5F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F); // Box 585
		bodyDoorCloseColoredPrimary[15].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[16].addShapeBox(-1F, -10F, -1.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F); // Box 586
		bodyDoorCloseColoredPrimary[16].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[17].addShapeBox(-1F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F); // Box 587
		bodyDoorCloseColoredPrimary[17].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[18].addShapeBox(-26.5F, -10F, 0.5F, 1, 8, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0.75F, 0F, -0.5F, 0.75F, 0F, -0.5F, -0.75F, 0F, -0.5F, -0.75F); // Box 588
		bodyDoorCloseColoredPrimary[18].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[19].addShapeBox(-26.5F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 589
		bodyDoorCloseColoredPrimary[19].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[20].addShapeBox(-26.5F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 590
		bodyDoorCloseColoredPrimary[20].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[21].addShapeBox(-1F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 591
		bodyDoorCloseColoredPrimary[21].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[22].addShapeBox(-1F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 592
		bodyDoorCloseColoredPrimary[22].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[23].addShapeBox(-9F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, -1F, 4F, 0F, -1F, 4F, 0F, 1F, -4F, 0F, 1F); // Box 593
		bodyDoorCloseColoredPrimary[23].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[24].addShapeBox(-9F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -4F, 0F, 1F, 4F, 0F, 1F, 4F, 0F, -1F, -4F, 0F, -1F); // Box 594
		bodyDoorCloseColoredPrimary[24].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[25].addShapeBox(-18.5F, -17F, 1.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, 1F, -4F, 0F, 1F, -4F, 0F, -1F, 4F, 0F, -1F); // Box 595
		bodyDoorCloseColoredPrimary[25].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[26].addShapeBox(-18.5F, -17F, -2.5F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 4F, 0F, -1F, -4F, 0F, -1F, -4F, 0F, 1F, 4F, 0F, 1F); // Box 596
		bodyDoorCloseColoredPrimary[26].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[27].addShapeBox(-25.5F, -17F, -2.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F); // Box 597
		bodyDoorCloseColoredPrimary[27].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[28].addShapeBox(-25.5F, -17F, 1.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F); // Box 599
		bodyDoorCloseColoredPrimary[28].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[29].addShapeBox(-18F, -17F, 1.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F); // Box 600
		bodyDoorCloseColoredPrimary[29].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[30].addShapeBox(-18F, -17F, -2.5F, 17, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.142857142857143F, 0F, 0F, -0.142857142857143F, 0F, 0F, 0.142857142857143F, 0F, 0F, 0.142857142857143F); // Box 601
		bodyDoorCloseColoredPrimary[30].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[31].addShapeBox(-24F, 0F, -0.1F, 3, 1, 1, 0F,0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0.4F, 0F, 0F, 0.4F, 0F, 0F); // Box 602
		bodyDoorCloseColoredPrimary[31].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[32].addShapeBox(-24F, 0F, -0.9F, 3, 1, 1, 0F,0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F); // Box 603
		bodyDoorCloseColoredPrimary[32].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[33].addShapeBox(-21F, 0F, -0.9F, 3, 1, 1, 0F,0.2F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0F, 0F, 0F, 0F, 0.4F, 0F, 0F, 0.4F); // Box 604
		bodyDoorCloseColoredPrimary[33].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[34].addShapeBox(-21F, 0F, -0.1F, 3, 1, 1, 0F,0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0.2F, 0F, -0.2F, 0F, 0F, 0.4F, 0F, 0F, 0.4F, 0.4F, 0F, 0F, 0.4F, 0F, 0F); // Box 605
		bodyDoorCloseColoredPrimary[34].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[35].addShapeBox(-12.5F, 0F, -1F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 606
		bodyDoorCloseColoredPrimary[35].setRotationPoint(25F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[36].addShapeBox(-12.5F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 607
		bodyDoorCloseColoredPrimary[36].setRotationPoint(25F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[37].addShapeBox(-7.5F, 0F, 0F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 608
		bodyDoorCloseColoredPrimary[37].setRotationPoint(-2.5F, -10F, -20.5F);

		bodyDoorCloseColoredPrimary[38].addShapeBox(-7.5F, 0F, -1F, 3, 1, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 609
		bodyDoorCloseColoredPrimary[38].setRotationPoint(-2.5F, -10F, 20.5F);

		bodyDoorCloseColoredPrimary[39].addShapeBox(-26.5F, 4F, -7F, 1, 1, 12, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.2F, 0F, 0F, -0.2F, 0F, 0F, -0.2F, 0F, 0F, 0.2F, 0F, 0F); // Box 649
		bodyDoorCloseColoredPrimary[39].setRotationPoint(-32F, -12F, 0F);

		bodyDoorCloseColoredPrimary[40].addShapeBox(-26.5F, 5F, -6F, 1, 3, 10, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0.3F, 0F, 0F, -0.3F, 0F, 0F, -0.3F, 0F, 0F, 0.3F, 0F, 0F); // Box 650
		bodyDoorCloseColoredPrimary[40].setRotationPoint(-32F, -12F, 0F);
	}

	private void initbodyColoredPrimary_1(){
		bodyColoredPrimary = new ModelRendererTurbo[73];
		bodyColoredPrimary[0] = new ModelRendererTurbo(this, 97, 113, textureX, textureY); // Box 439
		bodyColoredPrimary[1] = new ModelRendererTurbo(this, 409, 105, textureX, textureY); // Box 444
		bodyColoredPrimary[2] = new ModelRendererTurbo(this, 441, 105, textureX, textureY); // Box 445
		bodyColoredPrimary[3] = new ModelRendererTurbo(this, 473, 105, textureX, textureY); // Box 446
		bodyColoredPrimary[4] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 447
		bodyColoredPrimary[5] = new ModelRendererTurbo(this, 57, 113, textureX, textureY); // Box 448
		bodyColoredPrimary[6] = new ModelRendererTurbo(this, 73, 113, textureX, textureY); // Box 449
		bodyColoredPrimary[7] = new ModelRendererTurbo(this, 97, 113, textureX, textureY); // Box 457
		bodyColoredPrimary[8] = new ModelRendererTurbo(this, 153, 113, textureX, textureY); // Box 458
		bodyColoredPrimary[9] = new ModelRendererTurbo(this, 177, 113, textureX, textureY); // Box 459
		bodyColoredPrimary[10] = new ModelRendererTurbo(this, 505, 97, textureX, textureY); // Box 460
		bodyColoredPrimary[11] = new ModelRendererTurbo(this, 201, 113, textureX, textureY); // Box 461
		bodyColoredPrimary[12] = new ModelRendererTurbo(this, 401, 153, textureX, textureY); // Box 482
		bodyColoredPrimary[13] = new ModelRendererTurbo(this, 265, 113, textureX, textureY); // Box 484
		bodyColoredPrimary[14] = new ModelRendererTurbo(this, 201, 161, textureX, textureY); // Box 485
		bodyColoredPrimary[15] = new ModelRendererTurbo(this, 305, 113, textureX, textureY); // Box 486
		bodyColoredPrimary[16] = new ModelRendererTurbo(this, 65, 161, textureX, textureY); // Box 487
		bodyColoredPrimary[17] = new ModelRendererTurbo(this, 97, 169, textureX, textureY); // Box 488
		bodyColoredPrimary[18] = new ModelRendererTurbo(this, 137, 169, textureX, textureY); // Box 489
		bodyColoredPrimary[19] = new ModelRendererTurbo(this, 241, 169, textureX, textureY); // Box 490
		bodyColoredPrimary[20] = new ModelRendererTurbo(this, 401, 169, textureX, textureY); // Box 491
		bodyColoredPrimary[21] = new ModelRendererTurbo(this, 57, 129, textureX, textureY); // Box 494
		bodyColoredPrimary[22] = new ModelRendererTurbo(this, 369, 113, textureX, textureY); // Box 495
		bodyColoredPrimary[23] = new ModelRendererTurbo(this, 193, 129, textureX, textureY); // Box 496
		bodyColoredPrimary[24] = new ModelRendererTurbo(this, 409, 129, textureX, textureY); // Box 497
		bodyColoredPrimary[25] = new ModelRendererTurbo(this, 257, 169, textureX, textureY); // Box 498
		bodyColoredPrimary[26] = new ModelRendererTurbo(this, 241, 137, textureX, textureY); // Box 499
		bodyColoredPrimary[27] = new ModelRendererTurbo(this, 481, 145, textureX, textureY); // Box 500
		bodyColoredPrimary[28] = new ModelRendererTurbo(this, 361, 153, textureX, textureY); // Box 501
		bodyColoredPrimary[29] = new ModelRendererTurbo(this, 25, 161, textureX, textureY); // Box 502
		bodyColoredPrimary[30] = new ModelRendererTurbo(this, 489, 161, textureX, textureY); // Box 515
		bodyColoredPrimary[31] = new ModelRendererTurbo(this, 313, 169, textureX, textureY); // Box 516
		bodyColoredPrimary[32] = new ModelRendererTurbo(this, 313, 185, textureX, textureY); // Box 517
		bodyColoredPrimary[33] = new ModelRendererTurbo(this, 1, 185, textureX, textureY); // Box 518
		bodyColoredPrimary[34] = new ModelRendererTurbo(this, 89, 193, textureX, textureY); // Box 519
		bodyColoredPrimary[35] = new ModelRendererTurbo(this, 145, 193, textureX, textureY); // Box 520
		bodyColoredPrimary[36] = new ModelRendererTurbo(this, 233, 193, textureX, textureY); // Box 521
		bodyColoredPrimary[37] = new ModelRendererTurbo(this, 457, 169, textureX, textureY); // Box 522
		bodyColoredPrimary[38] = new ModelRendererTurbo(this, 369, 177, textureX, textureY); // Box 523
		bodyColoredPrimary[39] = new ModelRendererTurbo(this, 25, 185, textureX, textureY); // Box 527
		bodyColoredPrimary[40] = new ModelRendererTurbo(this, 465, 185, textureX, textureY); // Box 530
		bodyColoredPrimary[41] = new ModelRendererTurbo(this, 57, 185, textureX, textureY); // Box 531
		bodyColoredPrimary[42] = new ModelRendererTurbo(this, 313, 193, textureX, textureY); // Box 532
		bodyColoredPrimary[43] = new ModelRendererTurbo(this, 201, 185, textureX, textureY); // Box 533
		bodyColoredPrimary[44] = new ModelRendererTurbo(this, 481, 201, textureX, textureY); // Box 534
		bodyColoredPrimary[45] = new ModelRendererTurbo(this, 369, 193, textureX, textureY); // Box 535
		bodyColoredPrimary[46] = new ModelRendererTurbo(this, 177, 209, textureX, textureY); // Box 536
		bodyColoredPrimary[47] = new ModelRendererTurbo(this, 425, 193, textureX, textureY); // Box 537
		bodyColoredPrimary[48] = new ModelRendererTurbo(this, 25, 225, textureX, textureY); // Box 538
		bodyColoredPrimary[49] = new ModelRendererTurbo(this, 225, 225, textureX, textureY); // Box 539
		bodyColoredPrimary[50] = new ModelRendererTurbo(this, 225, 113, textureX, textureY); // Box 540
		bodyColoredPrimary[51] = new ModelRendererTurbo(this, 241, 113, textureX, textureY); // Box 541
		bodyColoredPrimary[52] = new ModelRendererTurbo(this, 265, 113, textureX, textureY); // Box 542
		bodyColoredPrimary[53] = new ModelRendererTurbo(this, 289, 113, textureX, textureY); // Box 543
		bodyColoredPrimary[54] = new ModelRendererTurbo(this, 345, 113, textureX, textureY); // Box 544
		bodyColoredPrimary[55] = new ModelRendererTurbo(this, 33, 121, textureX, textureY); // Box 545
		bodyColoredPrimary[56] = new ModelRendererTurbo(this, 305, 113, textureX, textureY); // Box 546
		bodyColoredPrimary[57] = new ModelRendererTurbo(this, 329, 113, textureX, textureY); // Box 547
		bodyColoredPrimary[58] = new ModelRendererTurbo(this, 409, 233, textureX, textureY); // Box 548
		bodyColoredPrimary[59] = new ModelRendererTurbo(this, 81, 241, textureX, textureY); // Box 549
		bodyColoredPrimary[60] = new ModelRendererTurbo(this, 137, 241, textureX, textureY); // Box 550
		bodyColoredPrimary[61] = new ModelRendererTurbo(this, 289, 241, textureX, textureY); // Box 551
		bodyColoredPrimary[62] = new ModelRendererTurbo(this, 57, 145, textureX, textureY); // Box 552
		bodyColoredPrimary[63] = new ModelRendererTurbo(this, 97, 145, textureX, textureY); // Box 553
		bodyColoredPrimary[64] = new ModelRendererTurbo(this, 369, 241, textureX, textureY); // Box 558
		bodyColoredPrimary[65] = new ModelRendererTurbo(this, 497, 97, textureX, textureY); // Box 565
		bodyColoredPrimary[66] = new ModelRendererTurbo(this, 409, 121, textureX, textureY); // Box 566
		bodyColoredPrimary[67] = new ModelRendererTurbo(this, 25, 129, textureX, textureY); // Box 567
		bodyColoredPrimary[68] = new ModelRendererTurbo(this, 433, 129, textureX, textureY); // Box 568
		bodyColoredPrimary[69] = new ModelRendererTurbo(this, 441, 129, textureX, textureY); // Box 569
		bodyColoredPrimary[70] = new ModelRendererTurbo(this, 505, 113, textureX, textureY); // Box 570
		bodyColoredPrimary[71] = new ModelRendererTurbo(this, 369, 265, textureX, textureY); // Box 567
		bodyColoredPrimary[72] = new ModelRendererTurbo(this, 1, 273, textureX, textureY); // Box 568

		bodyColoredPrimary[0].addBox(0F, 0F, 0F, 3, 11, 42, 0F); // Box 439
		bodyColoredPrimary[0].setRotationPoint(25F, -10F, -21F);

		bodyColoredPrimary[1].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F,0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, -4F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, 4F); // Box 444
		bodyColoredPrimary[1].setRotationPoint(45F, -8F, -14F);

		bodyColoredPrimary[2].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F,0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, -2F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 2F); // Box 445
		bodyColoredPrimary[2].setRotationPoint(32F, -8F, -14F);

		bodyColoredPrimary[3].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F,0F, 0F, -1F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, 1F, 0F, 0F, 2F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, -2F); // Box 446
		bodyColoredPrimary[3].setRotationPoint(32F, -8F, 12F);

		bodyColoredPrimary[4].addShapeBox(0F, 0F, 0F, 10, 9, 2, 0F,0F, 0F, 2F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, -2F, 0F, 0F, 4F, 0F, 0F, 2F, 0F, 0F, -2F, 0F, 0F, -4F); // Box 447
		bodyColoredPrimary[4].setRotationPoint(45F, -8F, 12F);

		bodyColoredPrimary[5].addShapeBox(0F, 0F, 0F, 3, 9, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F); // Box 448
		bodyColoredPrimary[5].setRotationPoint(42F, -8F, -12F);

		bodyColoredPrimary[6].addShapeBox(0F, 0F, 0F, 3, 9, 2, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 449
		bodyColoredPrimary[6].setRotationPoint(42F, -8F, 10F);

		bodyColoredPrimary[7].addShapeBox(0F, 0F, 0F, 3, 8, 12, 0F,0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 457
		bodyColoredPrimary[7].setRotationPoint(55F, -8F, 9F);

		bodyColoredPrimary[8].addShapeBox(0F, 0F, 0F, 3, 8, 12, 0F,1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F); // Box 458
		bodyColoredPrimary[8].setRotationPoint(55F, -8F, -21F);

		bodyColoredPrimary[9].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F,0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 459
		bodyColoredPrimary[9].setRotationPoint(58F, -2F, -9F);

		bodyColoredPrimary[10].addShapeBox(0F, 0F, 0F, 1, 8, 2, 0F,1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 460
		bodyColoredPrimary[10].setRotationPoint(58.2F, -8F, -1F);

		bodyColoredPrimary[11].addShapeBox(0F, 0F, 0F, 1, 2, 8, 0F,0.25F, 0F, 0F, -0.25F, 0F, 0F, -0.25F, 0F, 0F, 0.25F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 461
		bodyColoredPrimary[11].setRotationPoint(58F, -2F, 1F);

		bodyColoredPrimary[12].addShapeBox(0F, 0F, 0F, 9, 3, 12, 0F,0F, 1F, 0F, 0F, -1F, 0F, -1F, -1F, -1F, 1F, 1F, -1F, 0F, -2F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F); // Box 482
		bodyColoredPrimary[12].setRotationPoint(45F, -11F, 9F);

		bodyColoredPrimary[13].addShapeBox(0F, 0F, 0F, 3, 2, 12, 0F,0F, 0F, 0F, 0F, -1F, 0F, -1F, -1F, -1F, 1F, 0F, -1F, -1F, 0F, 0F, 1F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F); // Box 484
		bodyColoredPrimary[13].setRotationPoint(54F, -10F, 9F);

		bodyColoredPrimary[14].addShapeBox(0F, 0F, 0F, 16, 2, 12, 0F,0F, 0F, 0F, 1F, -1F, 0F, 0F, -1F, -1F, 0F, 0F, -1F, 0F, 1F, 0F, 1F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 485
		bodyColoredPrimary[14].setRotationPoint(28F, -13F, 9F);

		bodyColoredPrimary[15].addShapeBox(0F, 0F, 0F, 3, 2, 12, 0F,1F, 0F, -1F, -1F, -1F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 1F, 0F, 0F, -1F, 0F, 0F); // Box 486
		bodyColoredPrimary[15].setRotationPoint(54F, -10F, -21F);

		bodyColoredPrimary[16].addShapeBox(0F, 0F, 0F, 9, 3, 12, 0F,1F, 1F, -1F, -1F, -1F, -1F, 0F, -1F, 0F, 0F, 1F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 0F, -2F, 0F); // Box 487
		bodyColoredPrimary[16].setRotationPoint(45F, -11F, -21F);

		bodyColoredPrimary[17].addShapeBox(0F, 0F, 0F, 16, 2, 12, 0F,0F, 0F, -1F, 0F, -1F, -1F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 1F, 1F, 0F, 0F, 1F, 0F); // Box 488
		bodyColoredPrimary[17].setRotationPoint(28F, -13F, -21F);

		bodyColoredPrimary[18].addShapeBox(0F, 0F, 0F, 4, 2, 18, 0F,0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 489
		bodyColoredPrimary[18].setRotationPoint(54F, -10F, -9F);

		bodyColoredPrimary[19].addShapeBox(0F, 0F, 0F, 9, 2, 18, 0F,0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 2F, 0F, 0F, 2F, 0F, 0F, 0F, 0F); // Box 490
		bodyColoredPrimary[19].setRotationPoint(45F, -12F, -9F);

		bodyColoredPrimary[20].addShapeBox(0F, 0F, 0F, 17, 2, 18, 0F,0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, 1F, 0F); // Box 491
		bodyColoredPrimary[20].setRotationPoint(28F, -13F, -9F);

		bodyColoredPrimary[21].addShapeBox(0F, 0F, 0F, 6, 5, 8, 0F,0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, -3.5F, -0.5F, 1F, 0F, -0.5F, 0F, -0.5F, -0.5F, 0F, -3.5F, -0.5F, 0F); // Box 494
		bodyColoredPrimary[21].setRotationPoint(49F, -9F, 13F);

		bodyColoredPrimary[22].addShapeBox(0F, 0F, 0F, 3, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -2.5F, -0.5F, 1F, -0.5F, -0.5F, 1F, -0.5F, -0.5F, 0F, -2.5F, -0.5F, 0F); // Box 495
		bodyColoredPrimary[22].setRotationPoint(52.5F, -4.5F, 13F);

		bodyColoredPrimary[23].addShapeBox(0F, 0F, 0F, 6, 5, 8, 0F,0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, -3.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, 0F, -0.5F, 0F, -3.5F, -0.5F, 1F); // Box 496
		bodyColoredPrimary[23].setRotationPoint(49F, -9F, -21F);

		bodyColoredPrimary[24].addShapeBox(0F, 0F, 0F, 3, 5, 8, 0F,0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2.5F, -0.5F, 0F, -0.5F, -0.5F, 0F, -0.5F, -0.5F, 1F, -2.5F, -0.5F, 1F); // Box 497
		bodyColoredPrimary[24].setRotationPoint(52.5F, -4.5F, -21F);

		bodyColoredPrimary[25].addBox(0F, 0F, 0F, 4, 11, 42, 0F); // Box 498
		bodyColoredPrimary[25].setRotationPoint(28F, -10F, -21F);

		bodyColoredPrimary[26].addShapeBox(0F, 0F, 0F, 8, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F); // Box 499
		bodyColoredPrimary[26].setRotationPoint(32F, -10F, 13F);

		bodyColoredPrimary[27].addShapeBox(0F, 0F, 0F, 2, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 500
		bodyColoredPrimary[27].setRotationPoint(32F, -5F, 13F);

		bodyColoredPrimary[28].addShapeBox(0F, 0F, 0F, 8, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F); // Box 501
		bodyColoredPrimary[28].setRotationPoint(32F, -10F, -21F);

		bodyColoredPrimary[29].addShapeBox(0F, 0F, 0F, 2, 5, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 1F, 0F, 0F, 1F); // Box 502
		bodyColoredPrimary[29].setRotationPoint(32F, -5F, -21F);

		bodyColoredPrimary[30].addShapeBox(0F, 0F, 0F, 3, 10, 8, 0F,0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F); // Box 515
		bodyColoredPrimary[30].setRotationPoint(-58F, -10F, 13F);

		bodyColoredPrimary[31].addShapeBox(0F, 0F, 0F, 3, 10, 8, 0F,-1F, 0F, -1F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F); // Box 516
		bodyColoredPrimary[31].setRotationPoint(-58F, -10F, -21F);

		bodyColoredPrimary[32].addBox(0F, 0F, 0F, 3, 11, 42, 0F); // Box 517
		bodyColoredPrimary[32].setRotationPoint(-32F, -10F, -21F);

		bodyColoredPrimary[33].addBox(0F, 0F, 0F, 23, 11, 1, 0F); // Box 518
		bodyColoredPrimary[33].setRotationPoint(-55F, -10F, -14F);

		bodyColoredPrimary[34].addBox(0F, 0F, 0F, 23, 11, 1, 0F); // Box 519
		bodyColoredPrimary[34].setRotationPoint(-55F, -10F, 13F);

		bodyColoredPrimary[35].addShapeBox(0F, 0F, 0F, 22, 2, 8, 0F,0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 520
		bodyColoredPrimary[35].setRotationPoint(-54F, -12F, 13F);

		bodyColoredPrimary[36].addShapeBox(0F, 0F, 0F, 22, 2, 8, 0F,0F, 0F, -1F, 0F, 1F, -1F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 521
		bodyColoredPrimary[36].setRotationPoint(-54F, -12F, -21F);

		bodyColoredPrimary[37].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -2F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, -1F); // Box 522
		bodyColoredPrimary[37].setRotationPoint(-58F, -12F, 13F);

		bodyColoredPrimary[38].addShapeBox(0F, 0F, 0F, 4, 2, 8, 0F,-2F, 0F, -2F, 0F, 0F, -1F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 523
		bodyColoredPrimary[38].setRotationPoint(-58F, -12F, -21F);

		bodyColoredPrimary[39].addShapeBox(0F, 0F, 0F, 2, 2, 26, 0F,-0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 527
		bodyColoredPrimary[39].setRotationPoint(-59F, -2F, -13F);

		bodyColoredPrimary[40].addShapeBox(0F, 0F, 0F, 8, 5, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F); // Box 530
		bodyColoredPrimary[40].setRotationPoint(-40F, -10F, 14F);

		bodyColoredPrimary[41].addShapeBox(0F, 0F, 0F, 2, 6, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 531
		bodyColoredPrimary[41].setRotationPoint(-34F, -5F, 14F);

		bodyColoredPrimary[42].addShapeBox(0F, 0F, 0F, 8, 5, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, -0.5F, 0F, 0F); // Box 532
		bodyColoredPrimary[42].setRotationPoint(-55F, -10F, 14F);

		bodyColoredPrimary[43].addShapeBox(0F, 0F, 0F, 2, 6, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 533
		bodyColoredPrimary[43].setRotationPoint(-55F, -5F, 14F);

		bodyColoredPrimary[44].addShapeBox(0F, 0F, 0F, 8, 5, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -6F, 0F, 0F); // Box 534
		bodyColoredPrimary[44].setRotationPoint(-40F, -10F, -21F);

		bodyColoredPrimary[45].addShapeBox(0F, 0F, 0F, 2, 6, 7, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F); // Box 535
		bodyColoredPrimary[45].setRotationPoint(-34F, -5F, -21F);

		bodyColoredPrimary[46].addShapeBox(0F, 0F, 0F, 8, 5, 7, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.5F, 0F, 0F, -6F, 0F, 0F, -6F, 0F, 0F, 0F, 0F, 0F); // Box 536
		bodyColoredPrimary[46].setRotationPoint(-55F, -10F, -21F);

		bodyColoredPrimary[47].addShapeBox(0F, 0F, 0F, 2, 6, 7, 0F,-0.5F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F); // Box 537
		bodyColoredPrimary[47].setRotationPoint(-55F, -5F, -21F);

		bodyColoredPrimary[48].addShapeBox(0F, 0F, 0F, 3, 3, 42, 0F,0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 538
		bodyColoredPrimary[48].setRotationPoint(-32F, -13F, -21F);

		bodyColoredPrimary[49].addShapeBox(0F, 0F, 0F, 3, 3, 42, 0F,0F, 1F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 539
		bodyColoredPrimary[49].setRotationPoint(25F, -13F, -21F);

		bodyColoredPrimary[50].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F,4F, 0F, 1F, -4F, 0F, 1F, -4F, 0F, -1F, 4F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 540
		bodyColoredPrimary[50].setRotationPoint(25F, -20F, 19F);

		bodyColoredPrimary[51].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F,4F, 0F, -1F, -4F, 0F, -1F, -4F, 0F, 1F, 4F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 541
		bodyColoredPrimary[51].setRotationPoint(25F, -20F, -21F);

		bodyColoredPrimary[52].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 542
		bodyColoredPrimary[52].setRotationPoint(21F, -27F, 17F);

		bodyColoredPrimary[53].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,4F, 0F, 0F, -4F, 0F, 0F, -4F, 0F, 0F, 4F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 543
		bodyColoredPrimary[53].setRotationPoint(21F, -27F, -19F);

		bodyColoredPrimary[54].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F,-4F, 0F, 1F, 4F, 0F, 1F, 4F, 0F, -1F, -4F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 544
		bodyColoredPrimary[54].setRotationPoint(-31F, -20F, 19F);

		bodyColoredPrimary[55].addShapeBox(0F, 0F, 0F, 2, 10, 2, 0F,-4F, 0F, -1F, 4F, 0F, -1F, 4F, 0F, 1F, -4F, 0F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 545
		bodyColoredPrimary[55].setRotationPoint(-31F, -20F, -21F);

		bodyColoredPrimary[56].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,-4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 546
		bodyColoredPrimary[56].setRotationPoint(-27F, -27F, 17F);

		bodyColoredPrimary[57].addShapeBox(0F, 0F, 0F, 2, 7, 2, 0F,-4F, 0F, 0F, 4F, 0F, 0F, 4F, 0F, 0F, -4F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 547
		bodyColoredPrimary[57].setRotationPoint(-27F, -27F, -19F);

		bodyColoredPrimary[58].addShapeBox(0F, 0F, 0F, 42, 1, 2, 0F,-1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 548
		bodyColoredPrimary[58].setRotationPoint(-23F, -28F, 17F);

		bodyColoredPrimary[59].addShapeBox(0F, 0F, 0F, 42, 1, 2, 0F,-1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 549
		bodyColoredPrimary[59].setRotationPoint(-23F, -28F, -19F);

		bodyColoredPrimary[60].addShapeBox(0F, 0F, 0F, 10, 1, 34, 0F,0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 550
		bodyColoredPrimary[60].setRotationPoint(9F, -28F, -17F);

		bodyColoredPrimary[61].addShapeBox(0F, 0F, 0F, 20, 1, 34, 0F,-1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 551
		bodyColoredPrimary[61].setRotationPoint(-23F, -28F, -17F);

		bodyColoredPrimary[62].addBox(0F, 0F, 0F, 12, 1, 7, 0F); // Box 552
		bodyColoredPrimary[62].setRotationPoint(-3F, -28F, -17F);

		bodyColoredPrimary[63].addBox(0F, 0F, 0F, 12, 1, 7, 0F); // Box 553
		bodyColoredPrimary[63].setRotationPoint(-3F, -28F, 10F);

		bodyColoredPrimary[64].addBox(0F, 0F, 0F, 11, 1, 19, 0F); // Box 558
		bodyColoredPrimary[64].setRotationPoint(-2.5F, -28F, -9.5F);

		bodyColoredPrimary[65].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 565
		bodyColoredPrimary[65].setRotationPoint(-2.5F, -27F, 18F);

		bodyColoredPrimary[66].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, 0F, 0F, -1F, 0F, 0F, 1F, 0F, 0F, 1F); // Box 566
		bodyColoredPrimary[66].setRotationPoint(-2.5F, -20F, 19F);

		bodyColoredPrimary[67].addBox(0F, 0F, 0F, 1, 10, 1, 0F); // Box 567
		bodyColoredPrimary[67].setRotationPoint(-2.5F, -10F, 20F);

		bodyColoredPrimary[68].addBox(0F, 0F, 0F, 1, 10, 1, 0F); // Box 568
		bodyColoredPrimary[68].setRotationPoint(-2.5F, -10F, -21F);

		bodyColoredPrimary[69].addShapeBox(0F, 0F, 0F, 1, 10, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 569
		bodyColoredPrimary[69].setRotationPoint(-2.5F, -20F, -20F);

		bodyColoredPrimary[70].addShapeBox(0F, 0F, 0F, 1, 7, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, 0F, 0F, 1F, 0F, 0F, -1F, 0F, 0F, -1F); // Box 570
		bodyColoredPrimary[70].setRotationPoint(-2.5F, -27F, -19F);

		bodyColoredPrimary[71].addBox(0F, 0F, 0F, 54, 1, 1, 0F); // Box 567
		bodyColoredPrimary[71].setRotationPoint(-29F, 0F, 20F);

		bodyColoredPrimary[72].addBox(0F, 0F, 0F, 54, 1, 1, 0F); // Box 568
		bodyColoredPrimary[72].setRotationPoint(-29F, 0F, -21F);
	}

	private void initsteering_1(){
		steering = new ModelRendererTurbo[18];
		steering[0] = new ModelRendererTurbo(this, 177, 113, textureX, textureY); // Box 711
		steering[1] = new ModelRendererTurbo(this, 217, 113, textureX, textureY); // Box 712
		steering[2] = new ModelRendererTurbo(this, 121, 121, textureX, textureY); // Box 713
		steering[3] = new ModelRendererTurbo(this, 281, 41, textureX, textureY); // Box 714
		steering[4] = new ModelRendererTurbo(this, 345, 41, textureX, textureY); // Box 715
		steering[5] = new ModelRendererTurbo(this, 249, 177, textureX, textureY); // Box 719
		steering[6] = new ModelRendererTurbo(this, 73, 185, textureX, textureY); // Box 721
		steering[7] = new ModelRendererTurbo(this, 385, 193, textureX, textureY); // Box 754
		steering[8] = new ModelRendererTurbo(this, 345, 81, textureX, textureY); // Box 755
		steering[9] = new ModelRendererTurbo(this, 297, 97, textureX, textureY); // Box 756
		steering[10] = new ModelRendererTurbo(this, 41, 201, textureX, textureY); // Box 757
		steering[11] = new ModelRendererTurbo(this, 57, 201, textureX, textureY); // Box 758
		steering[12] = new ModelRendererTurbo(this, 73, 201, textureX, textureY); // Box 759
		steering[13] = new ModelRendererTurbo(this, 121, 113, textureX, textureY); // Box 760
		steering[14] = new ModelRendererTurbo(this, 81, 129, textureX, textureY); // Box 761
		steering[15] = new ModelRendererTurbo(this, 209, 201, textureX, textureY); // Box 762
		steering[16] = new ModelRendererTurbo(this, 345, 201, textureX, textureY); // Box 763
		steering[17] = new ModelRendererTurbo(this, 1, 209, textureX, textureY); // Box 764

		steering[0].addBox(-1F, -1F, -1F, 1, 2, 2, 0F); // Box 711
		steering[0].setRotationPoint(15F, -14F, 11F);

		steering[1].addBox(-1F, 3F, -1F, 1, 1, 2, 0F); // Box 712
		steering[1].setRotationPoint(15F, -14F, 11F);

		steering[2].addBox(-1F, -4F, -1F, 1, 1, 2, 0F); // Box 713
		steering[2].setRotationPoint(15F, -14F, 11F);

		steering[3].addBox(-1F, -1F, 3F, 1, 2, 1, 0F); // Box 714
		steering[3].setRotationPoint(15F, -14F, 11F);

		steering[4].addBox(-1F, -1F, -4F, 1, 2, 1, 0F); // Box 715
		steering[4].setRotationPoint(15F, -14F, 11F);

		steering[5].addShapeBox(-1F, 3F, 1F, 1, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 719
		steering[5].setRotationPoint(15F, -14F, 11F);

		steering[6].addShapeBox(-1F, 2F, -0.5F, 1, 1, 3, 0F,-0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 721
		steering[6].setRotationPoint(15F, -14F, 11F);

		steering[7].addShapeBox(-1F, 3F, 1F, 1, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 754
		steering[7].setRotationPoint(15F, -14F, 11F);

		steering[8].addShapeBox(-1F, 1F, 3F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, -1F, -1F, 0F, -1F, -1F); // Box 755
		steering[8].setRotationPoint(15F, -14F, 11F);

		steering[9].addShapeBox(-1F, -4F, 3F, 1, 3, 1, 0F,0F, -2F, 1F, 0F, -2F, 1F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 756
		steering[9].setRotationPoint(15F, -14F, 11F);

		steering[10].addShapeBox(-1F, -4F, 1F, 1, 1, 3, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F); // Box 757
		steering[10].setRotationPoint(15F, -14F, 11F);

		steering[11].addShapeBox(-1F, -4F, -4F, 1, 1, 3, 0F,0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 758
		steering[11].setRotationPoint(15F, -14F, 11F);

		steering[12].addShapeBox(-1F, 3F, -4F, 1, 1, 3, 0F,0F, 1F, -2F, 0F, 1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 759
		steering[12].setRotationPoint(15F, -14F, 11F);

		steering[13].addShapeBox(-1F, -4F, -4F, 1, 3, 1, 0F,0F, -1F, -1F, 0F, -1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 760
		steering[13].setRotationPoint(15F, -14F, 11F);

		steering[14].addShapeBox(-1F, 1F, -4F, 1, 3, 1, 0F,0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -1F, -1F, 0F, -1F, -1F, 0F, -2F, 1F, 0F, -2F, 1F); // Box 761
		steering[14].setRotationPoint(15F, -14F, 11F);

		steering[15].addShapeBox(-1F, -3F, -2.5F, 1, 1, 3, 0F,-0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F); // Box 762
		steering[15].setRotationPoint(15F, -14F, 11F);

		steering[16].addShapeBox(-1F, -3F, -0.5F, 1, 1, 3, 0F,-0.1F, -3F, 0F, -0.1F, -3F, 0F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F); // Box 763
		steering[16].setRotationPoint(15F, -14F, 11F);

		steering[17].addShapeBox(-1F, 2F, -2.5F, 1, 1, 3, 0F,-0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, 2F, -1F, -0.1F, 2F, -1F, -0.1F, 0F, 0F, -0.1F, 0F, 0F, -0.1F, -3F, 0F, -0.1F, -3F, 0F); // Box 764
		steering[17].setRotationPoint(15F, -14F, 11F);
	}
	
}