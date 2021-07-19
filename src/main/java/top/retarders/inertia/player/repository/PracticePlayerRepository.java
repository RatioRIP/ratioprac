package top.retarders.inertia.player.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import top.retarders.inertia.player.PracticePlayer;
import top.retarders.inertia.repository.Repository;

public class PracticePlayerRepository implements Repository<UUID, PracticePlayer> {

  private final ArrayList<PracticePlayer> repository = new ArrayList<>();

  @Override
  public Collection<PracticePlayer> findAll() {
    return this.repository;
  }

  public PracticePlayer find(UUID key) {
    return this.repository.stream()
        .filter(practicePlayer -> practicePlayer.uuid.equals(key))
        .findFirst()
        .orElse(null);
  }

  @Override
  public boolean insert(UUID key, PracticePlayer value) {
    // guess how many fucks i give about the key lmao :clown:
    return this.repository.add(value);
  }

  @Override
  public boolean remove(UUID key) {
    Optional<PracticePlayer> found = this.repository.stream()
        .filter(practicePlayer -> practicePlayer.uuid.equals(key))
        .findFirst();

    if (!found.isPresent()) return false;

    return this.repository.remove(found.get());
  }
}
