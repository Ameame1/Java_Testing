package processors;

/** Exception thrown when execution of shell commands fails.
 */
public class ExecutionException extends Exception {

  private static final long serialVersionUID = 1L;

  /** Construct an exception by supplying a message string.
   *
   * @param message A message
   */
  public ExecutionException(String message) {
    super(message);
  }

  /** Construct an exception by supplying a Throwable
   * that caused it.
   *
   * @param cause A Throwable that caused the exception
   */
  public ExecutionException(Throwable cause) {
    super(cause);
  }

  /** Construct an exception by supplying a string message and
   * a Throwable that caused it.
   *
   * @param message
   * @param cause
   */
  public ExecutionException(String message, Throwable cause) {
    super(message, cause);
  }

  /** Construct an exception by  supplying a string message,
   *  a Throwable cause, and flags indicating whether suppression behaviour
   *  is enabled and the stack trace is writable.
   *
   * @param message
   * @param cause
   * @param enableSuppression
   * @param writableStackTrace
   */
  public ExecutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
