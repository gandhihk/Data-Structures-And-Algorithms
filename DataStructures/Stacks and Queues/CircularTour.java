package ds.stacksAndQueues;

public class CircularTour {
    // A petrol pump has petrol and distance to next petrol pump
    static class PetrolPump
    {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance)
        {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {

        PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};

        int start = tour(arr, arr.length);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);

    }

    static int tour(PetrolPump[] pumps, int length){
        int extraFuel=0, reqFuel=0;
        int start=0;

        for(int i=0; i<length; i++){
            extraFuel += pumps[i].petrol - pumps[i].distance;

            if(extraFuel < 0){
                start = i+1;
                reqFuel += extraFuel;
                extraFuel = 0;
            }
        }

        if(extraFuel + reqFuel < 0)
            return -1;
        else
            return start;
    }
}
