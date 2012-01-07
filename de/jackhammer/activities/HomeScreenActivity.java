package de.jackhammer.activities;

import android.app.Activity;
import android.os.Bundle;
import de.jackhammer.ClanApplication;
import de.jackhammer.R;
import de.jackhammer.comparator.MemberComparators;
import de.jackhammer.members.ClanMember;
import de.jackhammer.members.FactoryMember;

import java.util.Collections;
import java.util.List;

public class HomeScreenActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen );

    }


}
