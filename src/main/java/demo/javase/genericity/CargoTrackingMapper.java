package demo.javase.genericity;

import demo.javase.genericity.dto.AssetContent;
import demo.javase.genericity.dto.CargoTrackingDTO;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class CargoTrackingMapper extends EventMapper<CargoTrackingDTO> {

  private Milestone buildMilestone(CargoTrackingDTO dto){
    return null;
  }

  private RoutePointSupp buildRoutePointSupp(Milestone milestone){
    return null;
  }

  private EffectiveEnd buildEffectiveEnd(RoutePointSupp supp){
    return null;
  }

  private void save(Milestone milestone, RoutePointSupp supp, EffectiveEnd end){

  }

  @Override
  public void map(CargoTrackingDTO input) {
    Wrapper<Milestone> milestoneW = new Wrapper<>();
    Wrapper<RoutePointSupp> routePointSuppW = new Wrapper<>();
    Wrapper<EffectiveEnd> effectiveEndW = new Wrapper<>();
    new CTProcessor()
      .process(input)
      .process(this::buildMilestone, milestoneW)
      .process(this::buildRoutePointSupp, milestoneW.get(), routePointSuppW)
      .process(this::buildEffectiveEnd, routePointSuppW.get(), effectiveEndW)
      .process((dto) -> this.save(milestoneW.get(), routePointSuppW.get(), effectiveEndW.get()))
      .result();
  }

  class CTProcessor extends EventProcessor<CargoTrackingDTO, Optional<?>>{

    @Override
    public CTProcessor process(CargoTrackingDTO input) {
      return this;
    }
  }
}
