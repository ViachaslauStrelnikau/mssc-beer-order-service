package guru.sfg.beer.order.service.services.sm;

import guru.sfg.beer.order.service.domain.BeerOrderEventsEnum;
import guru.sfg.beer.order.service.domain.BeerOrderStatusEnum;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;

public class StateChangeInterceptor extends StateMachineInterceptorAdapter<BeerOrderStatusEnum, BeerOrderEventsEnum> {

    @Override
    public void preStateChange(State<BeerOrderStatusEnum, BeerOrderEventsEnum> state, Message<BeerOrderEventsEnum> message, Transition<BeerOrderStatusEnum, BeerOrderEventsEnum> transition, StateMachine<BeerOrderStatusEnum, BeerOrderEventsEnum> stateMachine, StateMachine<BeerOrderStatusEnum, BeerOrderEventsEnum> rootStateMachine) {
        super.preStateChange(state, message, transition, stateMachine, rootStateMachine);
    }
}
