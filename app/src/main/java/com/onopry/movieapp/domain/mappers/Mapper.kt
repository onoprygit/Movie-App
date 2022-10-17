package com.onopry.movieapp.domain.mappers


//todo: not sure about mapper location in this layer of app
interface Mapper<SRC, DST> {
    fun transform(data: SRC): DST
}