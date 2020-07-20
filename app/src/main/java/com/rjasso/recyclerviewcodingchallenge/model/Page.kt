import com.google.gson.annotations.SerializedName

data class Page (

	@SerializedName("cards") val  cards : List<Cards>
)