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



    public int[] getInputs(String rawCoordinates) throws NumberFormatException
    {

        try {
            if (rawCoordinates.equals("help")) {
                currentInputs[0] = -1;
                currentInputs[1] = -1;
            }
            else if(rawCoordinates.equals("new game"))
            {
                currentInputs[0] = -3;
                currentInputs[1] = -3;
            }

            else if (rawCoordinates.charAt(0) == 'F') {
                flag = true;
                String[] coordinatesArray = rawCoordinates.split(" ");
                currentInputs[0] = Integer.parseInt(coordinatesArray[1]);
                currentInputs[1] = Integer.parseInt(coordinatesArray[2]);


            } else {
                String[] coordinatesArray = rawCoordinates.split(" ");
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
