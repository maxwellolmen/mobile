package com.maxwellolmen.togl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AsyncStarter implements Runnable {

    private Activity act;
    private Intent iet;
    private Bundle bun;

    public AsyncStarter(Activity act, Intent iet, Bundle bun) {
        this.act = act;
        this.iet = iet;
        this.bun = bun;
    }

    @Override
    public void run() {
        iet.putExtras(bun);
        act.startActivity(iet);
    }
}
