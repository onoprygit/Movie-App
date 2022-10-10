package com.onopry.movieapp.domain.mappers

interface Mapper<SRC, DST> {
    fun transform(data: SRC): DST
}