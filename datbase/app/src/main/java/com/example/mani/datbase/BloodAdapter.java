package com.example.mani.datbase;


/**
 * Created by akash on 04-Dec-17.
 */


        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.CompoundButton;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.widget.ToggleButton;


        import com.example.mani.datbase.R;
        import com.example.mani.datbase.helper;
        import com.example.mani.datbase.Blood;


        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;


public class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.BloodViewHolder> {

    private List<Blood> Blood;
    private int rowLayout;
    private Context context;
    private final String TAG = "Updating the blood";
    helper db;


    public static class BloodViewHolder extends RecyclerView.ViewHolder {
        LinearLayout BloodLayout;
        TextView name;
        TextView hostel;
        TextView age;
        TextView bloodgroup;




        public BloodViewHolder(View v) {
            super(v);
            BloodLayout = (LinearLayout) v.findViewById(R.id.bloodlist);
            name = (TextView) v.findViewById(R.id.name);
            bloodgroup = (TextView) v.findViewById(R.id.bloodgroup);
            hostel = (TextView) v.findViewById(R.id.hostel);


        }
    }

    public BloodAdapter(List<Blood> Blood, int rowLayout, Context context) {
        this.Blood = Blood;
        this.rowLayout = rowLayout;
        this.context = context;
        db = new helper(context);
    }

    @Override
    public BloodAdapter.BloodViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new BloodViewHolder(view);
    }


    @Override
    public void onBindViewHolder(BloodViewHolder holder, final int position) {
        holder.name.setText(Blood.get(position).getName());
        holder.hostel.setText(Blood.get(position).getHostel());
        holder.bloodgroup.setText(Blood.get(position).getBloodgroup());

        Blood newBlood = new Blood(Blood.get(position).getName(), Blood.get(position).getHostel(), Blood.get(position).getBloodgroup());




    }

    @Override
    public int getItemCount() {
        return Blood.size();
    }


    }
