package com.prawin.cinescope.custom_widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prawin.cinescope.R
import com.prawin.cinescope.ui.theme.darkReddish

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    BasicTextField(
        value = text,
        onValueChange = { onValueChange(it) },
        modifier = modifier
            .height(32.dp)
            .width(OutlinedTextFieldDefaults.MinWidth),
        interactionSource = interactionSource,
        textStyle = TextStyle(fontSize = 16.sp, color = darkReddish),
    ) { innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            placeholder = {
                Text(
                    text = stringResource(R.string.search_by_movie),
                    color = darkReddish,
                    modifier = Modifier.alpha(0.5f)
                )
            },
            value = text,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            interactionSource = interactionSource,
            visualTransformation = VisualTransformation.None,
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                top = 0.dp,
                bottom = 0.dp
            ),
            container = {
                Box(
                    modifier = Modifier.border(
                        color = darkReddish,
                        width = 1.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                )
            },
        )
    }
}