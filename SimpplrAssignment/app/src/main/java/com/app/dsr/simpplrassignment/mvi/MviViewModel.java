package com.app.dsr.simpplrassignment.mvi;

import io.reactivex.Observable;

public interface MviViewModel<I extends MVIIntent, S extends MviViewState> {

    void processIntents(Observable<I> intents);

    Observable<S> states();

}
