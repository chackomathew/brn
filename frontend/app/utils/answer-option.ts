import { urlForImage, urlForAudio } from 'brn/utils/file-url';
export default class AnswerOption {
  audioFileUrl: string | null = null;
  id: string | null = null;
  word = '';
  pictureFileUrl: string | null = null;
  columnNumber: number;
  constructor(
    {
      id,
      audioFileUrl,
      word,
      columnNumber,
      pictureFileUrl,
    }: {
      id: string;
      audioFileUrl?: null | string;
      columnNumber?: number;
      word: string;
      pictureFileUrl?: null | string;
    } = { id: '42', word: '', columnNumber: 0 },
  ) {
    // this.audioFileUrl = '/audio/no_noise/%D0%B1%D0%B0%D0%BB.mp3';
    this.audioFileUrl = audioFileUrl ? urlForAudio(audioFileUrl) : null;
    this.columnNumber = columnNumber ?? 0;
    this.id = id;
    this.word = word;
    this.pictureFileUrl = pictureFileUrl ? urlForImage(pictureFileUrl) : null;
    // this is for eslint, due to files bugfix
    if (!audioFileUrl || urlForAudio(audioFileUrl)) {
      return;
    }
  }
}
