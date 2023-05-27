package com.example.myapplication.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.DialogFragment;

import com.example.myapplication.sinterface.DeleteInterface;

public class DeleteFragment extends DialogFragment {

    private String message;
    private Long id;
    private DeleteInterface deleteInterface;

    public DeleteFragment(String message, Long id, DeleteInterface deleteInterface) {
        this.message = message;
        this.id = id;
        this.deleteInterface = deleteInterface;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message+id+"?")
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteInterface.delete(id);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("Action","cancel");

                    }
                });
        return builder.create();
    }
}
