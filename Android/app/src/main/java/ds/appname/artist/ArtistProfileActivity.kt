package ds.appname.artist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ds.appname.R
import kotlinx.android.synthetic.main.activity_artist_profile.*

class ArtistProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_profile)
        creativeViewPagerView.setCreativeViewPagerAdapter(
            ArtistShowcaseAdapter(
                listOf(
                    "a",
                    "b",
                    "c"
                ), this
            )
        )
    }
}
