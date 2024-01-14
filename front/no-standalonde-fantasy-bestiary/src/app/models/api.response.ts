export interface ApiResponse<T> {
    status: string;
    timestamp: string; // assuming timestamp is a string in the format received from the backend
    data: T;
  }