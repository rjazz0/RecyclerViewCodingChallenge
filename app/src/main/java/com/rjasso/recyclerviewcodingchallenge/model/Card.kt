import com.google.gson.annotations.SerializedName

data class Card (
	@SerializedName("value") val value : String,
	@SerializedName("title") val title : Title,
	@SerializedName("image") val image : Image,
	@SerializedName("description") val description : Description,
	@SerializedName("attributes") val attributes : Attributes
)