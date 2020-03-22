package com.gbb.examples.subset;

import gbb.Configuration;
import gbb.Job;

/**
 * @author <a href="mailto:aurelian.hreapca@info.uaic.ro">Aurelian Hreapca</a> (created on 6/21/19)
 */
public class SubsetJob {

    public static void main(String[] args) throws Exception {
        Job job = getJob(20, 5);
        job.start();
        System.out.println((int) job.queryArray("solution", 0));
    }

    private static Job getJob(int n, int numberOfExecutors) {
        Configuration configuration = new Configuration.Builder()
                .withNumberOfExecutors(numberOfExecutors)
                .build();
        Job job = new Job.Builder()
                .withConfiguration(configuration)
                .withTask(SubsetTask.class)
                .withInitialState(SubsetState.getInitialState())
                .registerArray("n", new Integer[] {n})
                .registerArray("solution", new Integer[] {0})
                .build();

        return job;
    }
}
