package basic2;

/**
 * Created by yuliu on 6/27/16.
 */
//Consider an unlimited flow of data elements.How do you sample one ele from this flow such that at any point during
    //the processing of the flow you can return a random ele from the n ele read so far
    //Two methods for a sampling class
    //read(int value) - read one number from the flow
    //sample() - return at any time the sample, if n values have been read, the prob of returning any one of n
    //values is 1/n, return null if there is no value read so far
public class ReservoirSampling {
    //how many numbers have been read so far
    private int count;
    //only need to maintain the current sample.
    private Integer sample;
    public ReservoirSampling() {
        //own constructor
        //initialization, count is initialized as 0 since there is no single number read at the beginning.
        this.count = 0;
        this.sample = null;
    }
    public void read(int value) {
        count++;
        int prob = (int)(Math.random()*count);
        //the current read value has the prob of 1/count to be as the current sample;
        if (prob == 0) {
            sample = value;
        }

    }
}
