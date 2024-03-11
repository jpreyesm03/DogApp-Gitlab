public class Input {
    private int[] currentInputs;
    private boolean flag;


    public Input ()
    {
        flag = false;
        currentInputs = new int[2];

    }



    public boolean getFlag() {
        return flag;
    }

    public int[] getInputs(String rawCoords) throws NumberFormatException
    {
        try {
            if (rawCoords.equals("help")) {
                currentInputs[0] = -1;
                currentInputs[1] = -1;
            } else if (rawCoords.charAt(0) == 'F') {
                flag = true;
                String[] coordinatesArray = rawCoords.split(" ");
                currentInputs[0] = Integer.parseInt(coordinatesArray[1]);
                currentInputs[1] = Integer.parseInt(coordinatesArray[2]);


            } else {
                String[] coordinatesArray = rawCoords.split(" ");
                currentInputs[0] = Integer.parseInt(coordinatesArray[0]);
                currentInputs[1] = Integer.parseInt(coordinatesArray[1]);

            }
        }
        catch (NumberFormatException e )
        {
            currentInputs[0] = -2;
            currentInputs[1] = -2;
            throw new NumberFormatException();

        }

        return currentInputs;






    }

}
