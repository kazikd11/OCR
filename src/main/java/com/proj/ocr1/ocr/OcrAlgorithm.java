package com.proj.ocr1.ocr;

import java.awt.image.BufferedImage;

public class OcrAlgorithm {

    public String extractText(BufferedImage binaryImage) {
        StringBuilder text = new StringBuilder();
        int width = binaryImage.getWidth();
        int height = binaryImage.getHeight();

        for (int y = 0; y < height; y += 10) { 
            for (int x = 0; x < width; x += 10) { 
                if (isCharacterA(binaryImage, x, y)) {
                    text.append("A");
                } else if (isCharacterB(binaryImage, x, y)) {
                    text.append("B");
                } else if (isCharacterC(binaryImage, x, y)) {
                    text.append("C");
                } else if (isCharacterD(binaryImage, x, y)) {
                    text.append("D");
                } else if (isCharacterE(binaryImage, x, y)) {
                    text.append("E");
                } else if (isCharacterF(binaryImage, x, y)) {
                    text.append("F");
                } else if (isCharacterG(binaryImage, x, y)) {
                    text.append("G");
                } else if (isCharacterH(binaryImage, x, y)) {
                    text.append("H");
                } else if (isCharacterI(binaryImage, x, y)) {
                    text.append("I");
                } else if (isCharacterJ(binaryImage, x, y)) {
                    text.append("J");
                } else if (isCharacterK(binaryImage, x, y)) {
                    text.append("K");
                } else if (isCharacterL(binaryImage, x, y)) {
                    text.append("L");
                } else if (isCharacterM(binaryImage, x, y)) {
                    text.append("M");
                } else if (isCharacterN(binaryImage, x, y)) {
                    text.append("N");
                } else if (isCharacterO(binaryImage, x, y)) {
                    text.append("O");
                } else if (isCharacterP(binaryImage, x, y)) {
                    text.append("P");
                } else if (isCharacterQ(binaryImage, x, y)) {
                    text.append("Q");
                } else if (isCharacterR(binaryImage, x, y)) {
                    text.append("R");
                } else if (isCharacterS(binaryImage, x, y)) {
                    text.append("S");
                } else if (isCharacterT(binaryImage, x, y)) {
                    text.append("T");
                } else if (isCharacterU(binaryImage, x, y)) {
                    text.append("U");
                } else if (isCharacterV(binaryImage, x, y)) {
                    text.append("V");
                } else if (isCharacterW(binaryImage, x, y)) {
                    text.append("W");
                } else if (isCharacterX(binaryImage, x, y)) {
                    text.append("X");
                } else if (isCharacterY(binaryImage, x, y)) {
                    text.append("Y");
                } else if (isCharacterZ(binaryImage, x, y)) {
                    text.append("Z");
                } else if (isCharactera(binaryImage, x, y)) {
                    text.append("a");
                } else if (isCharacterb(binaryImage, x, y)) {
                    text.append("b");
                } else if (isCharacterc(binaryImage, x, y)) {
                    text.append("c");
                } else if (isCharacterd(binaryImage, x, y)) {
                    text.append("d");
                } else if (isCharactere(binaryImage, x, y)) {
                    text.append("e");
                } else if (isCharacterf(binaryImage, x, y)) {
                    text.append("f");
                } else if (isCharacterg(binaryImage, x, y)) {
                    text.append("g");
                } else if (isCharacterh(binaryImage, x, y)) {
                    text.append("h");
                } else if (isCharacteri(binaryImage, x, y)) {
                    text.append("i");
                } else if (isCharacterj(binaryImage, x, y)) {
                    text.append("j");
                } else if (isCharacterk(binaryImage, x, y)) {
                    text.append("k");
                } else if (isCharacterl(binaryImage, x, y)) {
                    text.append("l");
                } else if (isCharacterm(binaryImage, x, y)) {
                    text.append("m");
                } else if (isCharactern(binaryImage, x, y)) {
                    text.append("n");
                } else if (isCharactero(binaryImage, x, y)) {
                    text.append("o");
                } else if (isCharacterp(binaryImage, x, y)) {
                    text.append("p");
                } else if (isCharacterq(binaryImage, x, y)) {
                    text.append("q");
                } else if (isCharacterr(binaryImage, x, y)) {
                    text.append("r");
                } else if (isCharacters(binaryImage, x, y)) {
                    text.append("s");
                } else if (isCharactert(binaryImage, x, y)) {
                    text.append("t");
                } else if (isCharacteru(binaryImage, x, y)) {
                    text.append("u");
                } else if (isCharacterv(binaryImage, x, y)) {
                    text.append("v");
                } else if (isCharacterw(binaryImage, x, y)) {
                    text.append("w");
                } else if (isCharacterx(binaryImage, x, y)) {
                    text.append("x");
                } else if (isCharactery(binaryImage, x, y)) {
                    text.append("y");
                } else if (isCharacterz(binaryImage, x, y)) {
                    text.append("z");
                } else if (isCharacter0(binaryImage, x, y)) {
                    text.append("0");
                } else if (isCharacter1(binaryImage, x, y)) {
                    text.append("1");
                } else if (isCharacter2(binaryImage, x, y)) {
                    text.append("2");
                } else if (isCharacter3(binaryImage, x, y)) {
                    text.append("3");
                } else if (isCharacter4(binaryImage, x, y)) {
                    text.append("4");
                } else if (isCharacter5(binaryImage, x, y)) {
                    text.append("5");
                } else if (isCharacter6(binaryImage, x, y)) {
                    text.append("6");
                } else if (isCharacter7(binaryImage, x, y)) {
                    text.append("7");
                } else if (isCharacter8(binaryImage, x, y)) {
                    text.append("8");
                } else if (isCharacter9(binaryImage, x, y)) {
                    text.append("9");
                } else {
                    text.append(" ");
                }
            }
            text.append("\n");
        }
        return text.toString();
    }

    private boolean isCharacterA(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterB(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterC(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterD(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterE(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterF(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterG(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterH(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterI(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterJ(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterK(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0},
            {1, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterL(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterM(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterN(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterO(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterP(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterQ(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterR(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 0},
            {1, 0, 0, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterS(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterT(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterU(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterV(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterW(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterX(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterY(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterZ(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharactera(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 0, 1, 1, 0},
            {0, 1, 0, 0, 1},
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterb(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterc(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterd(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharactere(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterf(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterg(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterh(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacteri(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterj(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterk(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0},
            {1, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterl(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterm(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharactern(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharactero(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterp(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterq(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterr(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 0},
            {1, 0, 0, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacters(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharactert(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacteru(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterv(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterw(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterx(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharactery(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacterz(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter0(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter1(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter2(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter3(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter4(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter5(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter6(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter7(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter8(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean isCharacter9(BufferedImage image, int startX, int startY) {
        int[][] pattern = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };
        return matchesPattern(image, startX, startY, pattern);
    }

    private boolean matchesPattern(BufferedImage image, int startX, int startY, int[][] pattern) {
        for (int offsetY = 0; offsetY <= 5; offsetY++) {
            for (int offsetX = 0; offsetX <= 5; offsetX++) {
                boolean match = true;
                for (int y = 0; y < pattern.length; y++) {
                    for (int x = 0; x < pattern[y].length; x++) {
                        int pixel = (image.getRGB(startX + x + offsetX, startY + y + offsetY) & 0xFF) == 0 ? 1 : 0;
                        if (pixel != pattern[y][x]) {
                            match = false;
                            break;
                        }
                    }
                    if (!match) break;
                }
                if (match) return true;
            }
        }
        return false;
    }
}
