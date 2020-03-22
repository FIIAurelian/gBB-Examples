package com.gbb.examples.subset;

import gbb.State;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:aurelian.hreapca@info.uaic.ro">Aurelian Hreapca</a> (created on 6/21/19)
 */
public class SubsetState implements State {
    private List<Integer> positions;

    public SubsetState(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return this.positions;
    }

    public static SubsetState getInitialState() {
        return new SubsetState(new ArrayList<>());
    }
}
