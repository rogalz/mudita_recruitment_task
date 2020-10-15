package ext

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToast(@StringRes text: Int) = Toast.makeText(this.context, text, Toast.LENGTH_LONG).show()