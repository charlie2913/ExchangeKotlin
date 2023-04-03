package software.architecture.demo.dto

data class PaginationDto(
    val count: Int?,
    val limit: Int?,
    val offset: Int?,
    val total: Int?
) {
    constructor() : this(0, 0, 0, 0)
    @Override
    override fun toString(): String {
        return "PaginationDto{" +
                "count=" + count +
                ", limit=" + limit +
                ", offset=" + offset +
                ", total=" + total +
                '}'
    }

}