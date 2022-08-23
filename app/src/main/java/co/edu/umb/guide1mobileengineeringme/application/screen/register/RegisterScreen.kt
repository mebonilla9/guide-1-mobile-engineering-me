package co.edu.umb.guide1mobileengineeringme.application.screen.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.umb.guide1mobileengineeringme.application.screen.components.EventDialog
import co.edu.umb.guide1mobileengineeringme.application.screen.components.RoundedButton
import co.edu.umb.guide1mobileengineeringme.application.screen.components.SocialMediaButton
import co.edu.umb.guide1mobileengineeringme.application.screen.components.TransparentTextField
import co.edu.umb.guide1mobileengineeringme.ui.theme.FACEBOOKCOLOR
import co.edu.umb.guide1mobileengineeringme.ui.theme.GMAILCOLOR

@Composable
fun RegisterScreen(
  state: RegisterState,
  onRegister: (String, String, String, String,) -> Unit,
  onBack: () -> Unit,
  onDismissDialog: () -> Unit
) {

  val fullNameValue = remember { mutableStateOf("Manuel Bonilla") }
  val emailValue = remember { mutableStateOf("mail2@mail.com") }
  val passwordValue = remember { mutableStateOf("Test@123") }
  val confirmPasswordValue = remember { mutableStateOf("Test@123") }
  val focusManager = LocalFocusManager.current
  var passwordVisibility by remember { mutableStateOf(false) }
  var confirmPasswordVisibility by remember { mutableStateOf(false) }

  Box(
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(
          onClick = {
            onBack()
          }
        ) {
          Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Button",
            tint = MaterialTheme.colors.primary
          )
        }

        Text(
          text = "Create an Account",
          style = MaterialTheme.typography.h5.copy(
            color = MaterialTheme.colors.primary
          )
        )
      }

      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        TransparentTextField(
          textFieldValue = fullNameValue,
          textLabel = "Full Name",
          keyboardType = KeyboardType.Text,
          keyboardActions = KeyboardActions(
            onNext = {
              focusManager.moveFocus(FocusDirection.Down)
            }
          ),
          imeAction = ImeAction.Next
        )
        TransparentTextField(
          textFieldValue = emailValue,
          textLabel = "Email",
          keyboardType = KeyboardType.Email,
          keyboardActions = KeyboardActions(
            onNext = {
              focusManager.moveFocus(FocusDirection.Down)
            }
          ),
          imeAction = ImeAction.Next
        )
        TransparentTextField(
          textFieldValue = passwordValue,
          textLabel = "Password",
          keyboardType = KeyboardType.Password,
          keyboardActions = KeyboardActions(
            onNext = {
              focusManager.moveFocus(FocusDirection.Down)
            }
          ),
          imeAction = ImeAction.Next,
          trailingIcon = {
            IconButton(
              onClick = {
                passwordVisibility = !passwordVisibility
              }) {
              Icon(
                imageVector = if (passwordVisibility) {
                  Icons.Default.Visibility
                } else {
                  Icons.Default.VisibilityOff
                },
                contentDescription = "Toggle password Icon"
              )
            }
          },
          visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
          } else {
            PasswordVisualTransformation()
          }
        )
        TransparentTextField(
          textFieldValue = confirmPasswordValue,
          textLabel = "Confirm Password",
          keyboardType = KeyboardType.Password,
          keyboardActions = KeyboardActions(
            onNext = {
              focusManager.clearFocus()
              onRegister(
                fullNameValue.value,
                emailValue.value,
                passwordValue.value,
                confirmPasswordValue.value
              )
            }
          ),
          imeAction = ImeAction.Done,
          trailingIcon = {
            IconButton(
              onClick = {
                confirmPasswordVisibility = !confirmPasswordVisibility
              }) {
              Icon(
                imageVector = if (confirmPasswordVisibility) {
                  Icons.Default.Visibility
                } else {
                  Icons.Default.VisibilityOff
                },
                contentDescription = "Toggle password Icon"
              )
            }
          },
          visualTransformation = if (confirmPasswordVisibility) {
            VisualTransformation.None
          } else {
            PasswordVisualTransformation()
          }
        )

        Spacer(modifier = Modifier.height(16.dp))

        RoundedButton(
          text = "Sign up",
          displayProgressBar = state.displayProgressBar,
          onClick = {
            onRegister(
              emailValue.value,
              fullNameValue.value,
              passwordValue.value,
              confirmPasswordValue.value
            )
          }
        )

        ClickableText(
          text = buildAnnotatedString {
            append("Already have an account? ")
            withStyle(
              style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
              )
            ) {
              append("Log in")
            }
          },
          onClick = {
            onBack()
          }
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
        ) {
          Divider(
            modifier = Modifier.width(24.dp),
            thickness = 1.dp,
            color = Color.Gray
          )

          Text(
            modifier = Modifier.padding(8.dp),
            text = "OR",
            style = MaterialTheme.typography.h6.copy(
              fontWeight = FontWeight.Black
            )
          )

          Divider(
            modifier = Modifier.width(24.dp),
            thickness = 1.dp,
            color = Color.Gray
          )
        }

        Text(
          modifier = Modifier.fillMaxWidth(),
          text = "Login with",
          style = MaterialTheme.typography.body1.copy(
            MaterialTheme.colors.primary
          ),
          textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
          modifier = Modifier.fillMaxWidth(),
          verticalArrangement = Arrangement.spacedBy(8.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          SocialMediaButton(
            text = "Login with Facebook",
            onClick = {},
            socialMediaColor = FACEBOOKCOLOR
          )
          SocialMediaButton(
            text = "Login with Gmail",
            onClick = {},
            socialMediaColor = GMAILCOLOR
          )
        }
      }
    }

    if(state.errorMessage != null) {
      EventDialog(errorMessage = state.errorMessage, onDismiss = onDismissDialog)
    }
  }
}


@Composable
@Preview
fun PreviewRegister(viewModel: RegisterViewModel = RegisterViewModel()) {
  RegisterScreen(
    state = viewModel.state.value,
    onRegister = viewModel::register,
    onBack = {},
    onDismissDialog = viewModel::hideErrorDialog
  )
}