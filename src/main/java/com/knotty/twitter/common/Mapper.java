package com.knotty.twitter.common;

public interface Mapper<D, S> {
    D map(S source);
}
