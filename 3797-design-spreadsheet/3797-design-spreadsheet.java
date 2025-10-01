class Spreadsheet {
    private int[][] sheet; 

    public Spreadsheet(int rows) {
        sheet = new int[rows][26]; 
    }

    public void setCell(String cell, int value) {
        int[] pos = getCellPosition(cell);
        sheet[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = getCellPosition(cell);
        sheet[pos[0]][pos[1]] = 0;
    }
    public int getValue(String formula) {
        formula = formula.substring(1); 
        String[] parts = formula.split("\\+");
        int sum = 0;
        for (String part : parts) {
            part = part.trim();
            if (Character.isLetter(part.charAt(0))) {
                int[] pos = getCellPosition(part);
                sum += sheet[pos[0]][pos[1]];
            } else {
                sum += Integer.parseInt(part);
            }
        }
        return sum;
    }

    private int[] getCellPosition(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}
