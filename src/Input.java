public class Input {
    private int[] currentInputs;
    private boolean flag;
    private int x;
    private int y;


    public Input ()
    {
        flag = false;
        currentInputs = new int[2];


    }
    public void setSize(int x,int y)
    {
        this.x = x;
        this.y = y;
    }



    public boolean getFlag() {
        return flag;
    }



    public int[] getInputs(String rawCoordinates) throws NumberFormatException, ArrayIndexOutOfBoundsException
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
                    if (currentInputs[1] >= x || currentInputs[0] >= y )
                    {
                        throw new ArrayIndexOutOfBoundsException();
                    }


            } else {
                String[] coordinatesArray = rawCoordinates.split(" ");
                currentInputs[0] = Integer.parseInt(coordinatesArray[0]);
                currentInputs[1] = Integer.parseInt(coordinatesArray[1]);
                if (currentInputs[1] >= x || currentInputs[0] >= y )
                {
                    throw new ArrayIndexOutOfBoundsException();
                }

            }
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e )
        {
            currentInputs[0] = -2;
            currentInputs[1] = -2;


        }

        return currentInputs;






    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}
