package software.architecture.demo.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class NewsReqDto(
    val data: List<NewsDto>?,
    val pagination: PaginationDto?
) {
    constructor() : this(null, null)
    @Override
    override fun toString(): String {
        return "NewsReqDto{" +
                "data=" + data +
                ", pagination=" + pagination +
                '}'
    }
}