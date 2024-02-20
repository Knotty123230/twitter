package com.knotty.twitter.common.mapper;

public interface Mapper<D, S> {
    D map(S source);
}
