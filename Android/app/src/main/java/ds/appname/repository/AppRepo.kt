package ds.appname.repository

import ds.appname.R

class AppRepo {

    fun listOrder() = Endpoint.getEndpoint().orderList()

    fun getImage(label: String): Int {
        return when (label) {
            "monalisa" -> R.drawable.art_1
            "anting" -> R.drawable.anting_1
            "botol_anting" -> R.drawable.botol_antik_1
            else -> 0
        }
    }

    fun getArtist(label: String): String {
        return when (label) {
            "monalisa" -> "Leonardo Davinci"
            "anting" -> "Johannes Vermeer"
            "botol_antik" -> "Tokopedia"
            else -> ""
        }
    }
}