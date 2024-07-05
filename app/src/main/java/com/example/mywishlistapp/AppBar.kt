package com.example.mywishlistapp

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp


@Composable
fun AppBarView(
    title:String,
    onBackNavClicked:() -> Unit = {}
)
{
    val navigationIcon : (@Composable () -> Unit)? =
        {
            if(!title.contains("WishList"))
            {
                //Home view가 아닌 곳에서 Home view로 가기 위해 뒤로 가기 Composable을 따로 정의
                // home view에서는 따로 보여서는 안되기 때문에
                IconButton(onClick = { onBackNavClicked() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = Color.White//아이콘 색깔,
                        ,
                        contentDescription = null
                    )
                }

            } else {
                null
            }

        }

    //color의 경우 res의 values 패키지 안에 있는 colors에 white 색을 사용하겠다는 의미
    TopAppBar(title = { Text(text = title,color = colorResource(id = R.color.white),
        modifier = Modifier
            .padding(start = 4.dp)
            .heightIn(max = 24.dp)) }
        //padding을 왼쪽으로 4.dp 설정하고 내용의 최대 높이는 24.dp로 설정한다
    ,elevation = 3.dp,//그림자 효과
        backgroundColor = colorResource(id = R.color.app_bar_color)
        , navigationIcon = navigationIcon
        )


}