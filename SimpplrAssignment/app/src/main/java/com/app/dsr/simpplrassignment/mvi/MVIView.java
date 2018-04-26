package com.app.dsr.simpplrassignment.mvi;

import io.reactivex.Observable;

public interface MVIView<I extends MVIIntent, S extends MviViewState> {

    Observable<I> intents();

    void render(S state);

}
