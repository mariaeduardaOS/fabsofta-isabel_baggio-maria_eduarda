export interface LoginCredentials {
  email: string;
  password: string;
}

export interface RegisterData {
  nome: string;
  email: string;
  password: string;
}

export interface AuthResponse {
  token: string;
  expiresIn: number;
  user: {
    id: number;
    nome: string;
    email: string;
  };
}

export interface RegisterResponse {
  message: string;
  userId: number;
}