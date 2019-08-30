package ds.appname.model

import ds.appname.R

data class ArtCategory(
    val category: String,
    val firstArt: Int,
    val secondArt: Int,
    val thirdArt: Int
) {
    companion object {

        fun listArtCategory(): List<ArtCategory> {
            val list = mutableListOf<ArtCategory>()
            list.apply {
                add(ArtCategory("Portrait", R.drawable.art_1, R.drawable.art_2, R.drawable.art_3))
                add(ArtCategory("Lanskap", R.drawable.art_4, R.drawable.art_5, R.drawable.art_6))
            }
            return list
        }
    }
}