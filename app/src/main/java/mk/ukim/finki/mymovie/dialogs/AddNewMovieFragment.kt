package mk.ukim.finki.mymovie.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import mk.ukim.finki.mymovie.R

class AddNewMovieFragment:DialogFragment(){

    interface AddNewMovieDialogListener{
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?) :Dialog{
        return activity.let {
            val builder = AlertDialog.Builder(it)
            var inflater = requireActivity().layoutInflater
            val view: View = inflater.inflate(R.layout.movie_dialog, null)
            builder.setView(view)
                .setPositiveButton(R.string.ok, DialogInterface.OnClickListener{dialog, id ->})
                .setNegativeButton(R.string.cancel, DialogInterface.OnClickListener{dialog, id ->})

            builder.create()
        }?:throw IllegalStateException("Activity can not be null")
    }
}