package demo.javase.lock;

import com.sun.org.apache.bcel.internal.generic.LADD;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LatestMessageService {
  private MessageRepository<LatestMessage> repository;

  public static final int MAX_SIZE_OF_CACHE = 100;

  private static final Lock lock = new ReentrantLock();

  private static final Map<String, LatestMessage> cache = new LinkedHashMap<String, LatestMessage>() {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, LatestMessage> eldest) {
      return size() > MAX_SIZE_OF_CACHE;
    }
  };

  public void service(String id, Integer version) {
    LatestMessage persistedLatest = repository.findById(id);

    LatestMessage nextLatest = null;
    boolean versionUpdated = false;
    if (persistedLatest == null || persistedLatest.getVersion() < version) {

      synchronized (lock) {
        LatestMessage currentLatest = cache.get(id);
        if (currentLatest == null || currentLatest.getVersion() < version) {
          nextLatest = currentLatest != null ? currentLatest : (persistedLatest != null ? persistedLatest : new LatestMessage(id, version));
          nextLatest.setVersion(version);
          cache.put(id, nextLatest);
          versionUpdated = true;
        }
      }
    }else {
      return;
    }
    if (versionUpdated){
      repository.save(cache.get(id));
    }
  }

}
