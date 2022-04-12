package sv.edu.udb.viewmodelproject;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class ViewModelUV extends ViewModel {
    private double nxv;

    public double getNxv() {
        Log.d("GetDentro de viewmodel class: ", String.valueOf(nxv));
        return nxv;

    }

    public void setNxv(double nxv) {
        this.nxv = nxv;
        Log.d("SetDentro de viewmodel class: ", String.valueOf(nxv));
    }
}
