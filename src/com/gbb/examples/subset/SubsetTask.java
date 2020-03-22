package com.gbb.examples.subset;


import gbb.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:aurelian.hreapca@info.uaic.ro">Aurelian Hreapca</a> (created on 6/21/19)
 */
public class SubsetTask extends Task<SubsetState> {

    @Override
    public Collection<SubsetState> compute(SubsetState state) {
        getJob().applyOnArray("solution", x -> (Integer) x + 1, 0);

        List<SubsetState> nextStates = new ArrayList<>();
        List<Integer> positions = state.getPositions();

        int n = getJob().queryArray("n", 0);
        int lower = 1 + (positions.isEmpty() ? 0 : positions.get(positions.size() - 1));

        for (int i = lower; i <= n; i++) {
            List<Integer> nextPositions = new ArrayList<>(positions);
            nextPositions.add(i);
            nextStates.add(new SubsetState(nextPositions));
        }

        return nextStates;
    }
}
