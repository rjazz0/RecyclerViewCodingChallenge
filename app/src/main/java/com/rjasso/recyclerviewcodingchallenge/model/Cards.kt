import com.google.gson.annotations.SerializedName

data class Cards (

	@SerializedName("card_type") val card_type : String,
	@SerializedName("card") val card : Card
)