package com.reeadigital.movieApp.base.mapper

import com.reeadigital.movieApp.data.datasource.remote.dto.MovieErrorDTO
import com.skydoves.sandwich.ApiErrorModelMapper
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message

object ErrorResponseMapper : ApiErrorModelMapper<MovieErrorDTO> {
    override fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): MovieErrorDTO {
        return MovieErrorDTO(apiErrorResponse.statusCode.code, apiErrorResponse.message())
    }
}