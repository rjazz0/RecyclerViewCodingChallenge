import com.google.gson.annotations.SerializedName

data class Size (
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int
)