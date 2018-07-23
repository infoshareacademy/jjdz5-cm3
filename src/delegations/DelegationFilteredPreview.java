package delegations;

import java.util.List;
import java.util.stream.Collectors;

public class DelegationFilteredPreview extends DelegationPreview {
    @Override
    protected List<Delegation> getDelegations() {
        return super.getDelegations().stream()
                .filter((d -> d.getDelegationStatus() == DelegationStatus.TOACCEPT))
                .collect(Collectors.toList());
    }
}
