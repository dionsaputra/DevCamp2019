package ds.appname.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ds.appname.R
import kotlinx.android.synthetic.main.activity_art_detail.*

class ArtworkDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art_detail)

        buyArtworkButton.setOnClickListener { showDialogBuyArtworks() }
        hireArtistButton.setOnClickListener { showDialogHireArtist() }
    }

    private fun showDialogBuyArtworks() {
        BuyArtworksFragment().show(
            supportFragmentManager,
            BuyArtworksFragment::class.java.simpleName
        )
    }

    private fun showDialogHireArtist() {
        HireArtistFragment().show(
            supportFragmentManager,
            HireArtistFragment::class.java.simpleName
        )
    }
}
