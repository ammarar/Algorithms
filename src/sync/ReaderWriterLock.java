package sync;

public class ReaderWriterLock
{
	int writers = 0;
	int readers = 0;
	int writerRequests = 0;

	public synchronized void readLock() throws InterruptedException
	{
		while(writerRequests > 0 || writers > 0)
			wait();
		readers++;
	}
	
	public synchronized void readUnlock()
	{
		readers--;
		notifyAll();
	}
	
	public synchronized void writeLock() throws InterruptedException
	{
		writerRequests++;
		while(readers > 0 || writers > 0)
			wait();
		writerRequests--;
		writers++;
	}
	
	public synchronized void writeUnlock()
	{
		writers--;
		notifyAll();
	}
}
