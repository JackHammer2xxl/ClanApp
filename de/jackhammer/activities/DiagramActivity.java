package de.jackhammer.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LineGraphView;
import de.jackhammer.R;

/**
 * Created by IntelliJ IDEA.
 * User: JackHammer
 * Date: 26.11.11
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class DiagramActivity extends Activity {

    private GraphView.GraphViewSeries demoData1 = new GraphView.GraphViewSeries(new GraphView.GraphViewData[]{
                  new GraphView.GraphViewData(1, 2.0d)
                , new GraphView.GraphViewData(2, 1.5d)
                , new GraphView.GraphViewData(3, 2.5d)
                , new GraphView.GraphViewData(4, 1.0d)
        });
    private GraphView.GraphViewSeries demoData2 = new GraphView.GraphViewSeries(new GraphView.GraphViewData[]{
                  new GraphView.GraphViewData(1, 1.0d)
                , new GraphView.GraphViewData(2, 1.2d)
                , new GraphView.GraphViewData(3, 1.0d)
                , new GraphView.GraphViewData(4, 1.3d)
                , new GraphView.GraphViewData(5, 1.2d)
                , new GraphView.GraphViewData(6, 1.8d)
                , new GraphView.GraphViewData(7, 1.6d)
                , new GraphView.GraphViewData(8, 2.0d)
                , new GraphView.GraphViewData(9, 1.9d)
        });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagram);



        GraphView graphView = new LineGraphView(this  , "Statistic" );
//        graphView.addSeries(demoData1);
        graphView.addSeries(demoData2);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutGraph);
        layout.addView(graphView);

    }
}
