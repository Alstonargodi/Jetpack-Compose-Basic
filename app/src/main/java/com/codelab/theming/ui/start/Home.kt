import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.codelab.theming.data.PostRepo
import com.codelab.theming.ui.finish.theme.JetNewsTheme
import com.codelab.theming.ui.start.FeaturedPost

@Composable
fun Home(){
    MaterialTheme{

    }
}

@Preview(
    "feautred",
    showSystemUi = true
)
@Composable
private fun FeaturedPostPreview(){
    val post = remember {
        PostRepo.getFeaturedPost()
    }
    JetNewsTheme {
        FeaturedPost(post = post)
    }
}