import com.google.gson.annotations.SerializedName

data class Attributes (

	@SerializedName("text_color") val text_color : String,
	@SerializedName("font") val font : Font
)