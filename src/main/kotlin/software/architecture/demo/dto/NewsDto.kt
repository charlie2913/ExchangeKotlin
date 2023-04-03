package software.architecture.demo.dto

data class NewsDto(
    val title: String?,
    val description: String?,
    val url: String?,
    val published_at: String?,
    val source: String?,
    val tags: List<String>?,
    val tickers: List<String>?

) {
    constructor() : this(null, "", "", "", "", listOf(), listOf())
    @Override
    override fun toString(): String {
        return "NewsDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", publishedAt='" + published_at + '\'' +
                ", source='" + source + '\'' +
                ", tags=" + tags +
                ", tickers=" + tickers +
                '}'
    }
}