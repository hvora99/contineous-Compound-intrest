package lnclcgd.fnplaner.mortvatclc;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class OurAdapterr extends RecyclerView.Adapter<OurAdapterr.ViewHolder> {

    private List<String> values;
    private Context mContext;


    // Provide a suitable constructor (depends on the kind of dataset)
    OurAdapterr ( List<String> myDataset, Context context) {
        values = myDataset;
        mContext = context;
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView txtHeader;
        TextView txtFooter;
        public View layout;
        CardView cardView;

        ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById( R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            cardView = (CardView) v.findViewById(R.id.cardview);
        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }



    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder( ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = values.get(position);
        holder.txtHeader.setText(name);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String province = Integer.toString(position);

                //we retrieve the description of the juices from an array defined in arrays.xml
                String[] provincedescription = mContext.getResources().getStringArray(R.array.description);
                final String provincedesclabel = provincedescription[position];

                String[] headers = mContext.getResources().getStringArray(R.array.heading);
                final String heardernest = headers[position];


                Intent intent = new Intent(mContext, LoanDescription.class);
                intent.putExtra("province", heardernest);
                intent.putExtra("provincedesclabel", provincedesclabel);

                mContext.startActivity(intent);


            }
        });

        holder.txtFooter.setText("Click Here" + name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}